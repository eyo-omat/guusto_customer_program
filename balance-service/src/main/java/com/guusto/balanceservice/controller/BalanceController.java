package com.guusto.balanceservice.controller;

import com.guusto.balanceservice.model.Client;
import com.guusto.balanceservice.service.BalanceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {

    @NonNull
    private BalanceService balanceService;

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> fetchClientDetails(@PathVariable long clientId) {
        return ResponseEntity.ok(balanceService.fetchClientDetailsById(clientId));
    }
}
