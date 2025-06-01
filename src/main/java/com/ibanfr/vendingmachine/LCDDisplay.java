package com.ibanfr.vendingmachine;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

    @Override
    public void printMessageAfterDelay(String message, Duration duration) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> printMessage(message), duration.getSeconds(), TimeUnit.SECONDS);
    }
}
