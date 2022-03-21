package com.guusto.guustoservice.service;

import com.guusto.guustoservice.dto.BuyGiftCardRequest;
import com.guusto.guustoservice.dto.BuyGiftCardResponse;
import com.guusto.guustoservice.exceptions.ClientNotFoundException;
import com.guusto.guustoservice.exceptions.InsufficientBalanceException;
import com.guusto.guustoservice.model.Client;
import com.guusto.guustoservice.model.GiftCardTransaction;
import com.guusto.guustoservice.repository.ClientRepository;
import com.guusto.guustoservice.repository.TransactionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GiftCardService {

    @NonNull
    private ClientRepository clientRepository;

    @NonNull
    private TransactionRepository transactionRepository;

    @NonNull
    private RestTemplate restTemplate;

    public BuyGiftCardResponse buyGiftCard(BuyGiftCardRequest request) {
        // Fetch client balance from balance service
        Client client = restTemplate.getForObject("http://BALANCE-SERVICE/balance/{clientId}", Client.class, request.getClientId());
        if (client == null) {
            throw new ClientNotFoundException(String.format("Client with ID %d not found", request.getClientId()));
        }
        // compute total amount for purchase
        double totalCost = request.getAmount() * request.getQuantity();
        // validate client balance vs total amount
        if (totalCost > client.getBalance()) {
            // if client does not have enough balance thrown exception
            throw new InsufficientBalanceException(String.format(
                    "Current balance: %.2f is insufficient for purchase %.2f",
                    client.getBalance(),
                    totalCost)
            );
        }
        // update client balance
        client.setBalance(client.getBalance() - totalCost);
        clientRepository.save(client);
        // if client has enough save transaction and prepare response
        GiftCardTransaction giftCardTransaction = GiftCardTransaction.builder()
                .clientId(client)
                .amount(BigDecimal.valueOf(request.getAmount()))
                .quantity(request.getQuantity())
                .totalAmount(BigDecimal.valueOf(totalCost))
                .build();

        transactionRepository.save(giftCardTransaction);

        return BuyGiftCardResponse.builder()
                .balance(BigDecimal.valueOf(client.getBalance()))
                .quantity(giftCardTransaction.getQuantity())
                .totalCost(giftCardTransaction.getTotalAmount())
                .datePurchased(giftCardTransaction.getCreatedAt())
                .build();
    }

    public List<BuyGiftCardResponse> fetchAllTransactionsForClient(Long clientId) {
        Client client = restTemplate.getForObject("http://BALANCE-SERVICE/balance/{clientId}", Client.class, clientId);
        if (client == null) {
            throw new ClientNotFoundException(String.format("Client with ID %d not found", clientId));
        }

        return transactionRepository.findGiftCardTransactionsByClientId(client).stream()
                .map((giftCardTransaction) -> {
                    BuyGiftCardResponse buyGiftCardResponse = new BuyGiftCardResponse();
                    buyGiftCardResponse.setBalance(BigDecimal.valueOf(client.getBalance()));
                    buyGiftCardResponse.setQuantity(giftCardTransaction.getQuantity());
                    buyGiftCardResponse.setTotalCost(giftCardTransaction.getTotalAmount());
                    buyGiftCardResponse.setDatePurchased(giftCardTransaction.getCreatedAt());

                    return buyGiftCardResponse;
                }).collect(Collectors.toList());
    }
}
