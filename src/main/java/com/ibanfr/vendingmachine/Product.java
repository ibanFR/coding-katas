package com.ibanfr.vendingmachine;

import java.math.BigDecimal;

public class Product {
    private final int productNumber;
    private int quantity;
    private final String name;
    private final BigDecimal value;

    public Product(int productNumber, int quantity, String name, BigDecimal value) {
        this.productNumber = productNumber;
        this.quantity = quantity;
        this.name = name;
        this.value = value;
    }

    public int productNumber() {
        return productNumber;
    }

    public int quantity() {
        return quantity;
    }

    public String name() {
        return name;
    }

    public BigDecimal value() {
        return value;
    }

    public void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Insufficient quantity");
        }
        this.quantity -= amount;
    }
}
