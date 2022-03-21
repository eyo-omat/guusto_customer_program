package com.guusto.balanceservice.service;

import com.guusto.balanceservice.model.Client;
import com.guusto.balanceservice.repository.ClientRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BalanceService {

    @NonNull
    private ClientRepository clientRepository;

    public Client fetchClientDetailsById(long clientId) {
        log.info("Inside get user on Balance Service");
        return clientRepository.findByClientId(clientId);
    }
}
