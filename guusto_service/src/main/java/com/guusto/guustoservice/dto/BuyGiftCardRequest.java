package com.guusto.guustoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyGiftCardRequest {

    long clientId;
    int quantity;
    Double amount;

}
