package com.ibanfr.vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LCDDisplayTest {

    @Test
    @DisplayName("should print a message to the display")
    void should_print_a_message_to_the_display() {

        //test fixture
        String message = "Hello, World!";

        //given
        LCDDisplay display = new LCDDisplay();

        //when
        display.printMessage(message);

        //then
        assertThat(display.message()).isEqualTo(message);
    }
}