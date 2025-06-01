package com.ibanfr.vendingmachine;

public class LCDDisplay implements Display {

    private String message = "";

    @Override
    public String message() {
        return message;
    }

    @Override
    public void printMessage(String message) {
        this.message = message;
    }
}
