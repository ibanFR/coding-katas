package com.ibanfr.vendingmachine;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine {

    public static final String INSERT_COIN_MESSAGE = "INSERT COIN";
    Display display;
    private BigDecimal currentAmount;
    private BigDecimal returnAmount;
    private final List<Product> products;

    public VendingMachine(Display display) {
        this.display = display;
        this.currentAmount = BigDecimal.ZERO;
        this.display.printMessage(INSERT_COIN_MESSAGE);
        this.products = new ArrayList<>();
    }

    public String display() {
        return display.message();
    }

    public BigDecimal currentAmount() {
        return currentAmount;
    }

    public void insertCoin(Coin coin) {
        if (coin.equals(Coin.PENNY)) {
            returnAmount(Coin.PENNY.getValue());
            return;
        }
        this.currentAmount = currentAmount.add(coin.getValue());
        display.printMessage(currentAmountOrInsertCoin());
    }

    private String currentAmountOrInsertCoin() {
        if (currentAmount.compareTo(BigDecimal.ZERO) == 0) {
            return INSERT_COIN_MESSAGE;
        }
        return "$" + String.format("%.2f", currentAmount);
    }

    private void returnAmount(BigDecimal returnAmount){
        this.returnAmount = returnAmount;
    }

    public BigDecimal returnAmount() {
        return returnAmount;
    }

    public void returnCoins() {
        this.returnAmount = currentAmount;
        this.currentAmount = BigDecimal.ZERO;
        display.printMessage(INSERT_COIN_MESSAGE);
    }

    public List<Product> listProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProducts(List<Product> productList) {
        this.products.addAll(productList);
    }

    public void selectProduct(int productNumber) {

        if(sufficientAmountForProduct(productNumber)) {
            dispenseProduct(productNumber);
        } else {
            display.printMessage("PRICE: $" + String.format("%.2f", getProductPrice(productNumber)));
            display.printMessageAfterDelay(currentAmountOrInsertCoin(), Duration.ofSeconds(5));
        }
    }

    private BigDecimal getProductPrice(int productNumber) {
        return products.stream()
                .filter(product -> product.productNumber() == productNumber)
                .findFirst()
                .map(Product::value)
                .orElse(BigDecimal.ZERO);
    }

    boolean sufficientAmountForProduct(int productNumber) {
        return products.stream()
                .filter(product -> product.productNumber() == productNumber)
                .findFirst()
                .map(product -> currentAmount.compareTo(product.value()) >= 0)
                .orElse(false);
    }

    private void dispenseProduct(int productNumber) {
        returnChange(productNumber);
        this.currentAmount = BigDecimal.ZERO;
        products.stream()
                .filter(product -> product.productNumber() == productNumber)
                .findFirst()
                .ifPresent(product -> product.reduceQuantity(1));
        display.printMessage("THANK YOU");
        display.printMessageAfterDelay(INSERT_COIN_MESSAGE, Duration.ofSeconds(5));
    }

    private void returnChange(int productNumber) {
        this.returnAmount = this.currentAmount.subtract(getProductPrice(productNumber));
    }
}
