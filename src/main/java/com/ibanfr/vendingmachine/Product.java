package com.ibanfr.vendingmachine;

import java.math.BigDecimal;

public record Product(int productNumber, String name, BigDecimal value) {
}
