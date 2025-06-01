package com.ibanfr.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachine {

    Display display;
    private BigDecimal currentAmount;
    private BigDecimal returnAmount;
    private List<Product> products;

    public VendingMachine(Display display) {
        this.display = display;
        this.currentAmount = BigDecimal.ZERO;
        this.display.printMessage("INSERT COIN");
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
        display.printMessage("$"+String.format("%.2f", currentAmount));
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
        display.printMessage("INSERT COIN");
    }

    public List<Product> listProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProducts(List<Product> productList) {
        this.products.addAll(productList);
    }
}
