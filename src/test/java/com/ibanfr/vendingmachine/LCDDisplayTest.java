package com.ibanfr.vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

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

    @Test
    @DisplayName("should display message after 1 seconds")
    void should_display_message_after_1_seconds(){

        //given
        LCDDisplay display = new LCDDisplay();
        //when
        display.printMessageAfterDelay("Hello, World!", Duration.ofSeconds(1));

        //then
        assertThat(display.message()).isEmpty();

        await().atLeast(Duration.ofSeconds(1))
                .until(() -> display.message().equals("Hello, World!"));


    }

}