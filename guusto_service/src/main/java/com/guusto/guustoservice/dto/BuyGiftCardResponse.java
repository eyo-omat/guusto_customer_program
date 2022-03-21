package com.guusto.guustoservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyGiftCardResponse {

    BigDecimal balance;
    int quantity;
    BigDecimal totalCost;
    Date datePurchased;

}
