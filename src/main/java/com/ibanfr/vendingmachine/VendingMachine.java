package com.ibanfr.vendingmachine;

public class VendingMachine {

    Display display;

    public VendingMachine(Display display) {
        this.display = display;
        this.display.printMessage("INSERT COIN");
    }

    public String display() {
        return display.message();
    }
}
