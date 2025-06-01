package com.ibanfr.vendingmachine;

import java.math.BigDecimal;

public class VendingMachine {

    Display display;
    private BigDecimal currentAmount;

    public VendingMachine(Display display) {
        this.display = display;
        this.currentAmount = BigDecimal.ZERO;
        this.display.printMessage("INSERT COIN");
    }

    public String display() {
        return display.message();
    }

    public BigDecimal currentAmount() {
        return currentAmount;
    }

    public void insertCoin(Coin coin) {
        if (coin.equals(Coin.PENNY)) {
            return;
        }
        this.currentAmount = currentAmount.add(coin.getValue());
        display.printMessage("$"+String.format("%.2f", currentAmount));
    }
}
