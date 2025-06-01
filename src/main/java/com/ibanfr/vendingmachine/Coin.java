package com.ibanfr.vendingmachine;

import java.math.BigDecimal;

public enum Coin {
    NICKEL(BigDecimal.valueOf(0.05)),
    DIME(BigDecimal.valueOf(0.10)),
    PENNY(BigDecimal.valueOf(0.01)),
    QUARTER(BigDecimal.valueOf(0.25));

    private final BigDecimal value;

    Coin(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
