package com.guusto.guustoservice.controller;

import com.guusto.guustoservice.dto.BuyGiftCardRequest;
import com.guusto.guustoservice.dto.BuyGiftCardResponse;
import com.guusto.guustoservice.service.GiftCardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
