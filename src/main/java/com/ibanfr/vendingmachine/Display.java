package com.ibanfr.vendingmachine;

import java.time.Duration;

public interface Display {
    String message();

    void printMessage(String message);

    void printMessageAfterDelay(String message, Duration delay);
}
