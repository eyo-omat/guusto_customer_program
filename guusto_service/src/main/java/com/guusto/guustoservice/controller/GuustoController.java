package com.guusto.guustoservice.controller;

import com.guusto.guustoservice.dto.BuyGiftCardRequest;
import com.guusto.guustoservice.dto.BuyGiftCardResponse;
import com.guusto.guustoservice.service.GiftCardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "guusto-service")
@RequiredArgsConstructor
public class GuustoController {

    @NonNull
    private GiftCardService giftCardService;

    @PostMapping("/buy-gift")
    public ResponseEntity<BuyGiftCardResponse> buyGiftCard(@RequestBody @Valid BuyGiftCardRequest request) {
        BuyGiftCardResponse response = giftCardService.buyGiftCard(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/transaction-list/{clientId}")
    public ResponseEntity<List<BuyGiftCardResponse>> getAllTransactionsForClient(@PathVariable Long clientId) {
        List<BuyGiftCardResponse> responseList = giftCardService.fetchAllTransactionsForClient(clientId);
        return ResponseEntity.ok(responseList);
    }
}
