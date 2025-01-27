package com.ibanfr.liftbutton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LiftButtonTest {

    // TEST LIST
    // [X]- should switch lights on when button is pressed
    // [X]- should switch lights off when doors open
    // []- should keep lights on when button is pressed while doors are closed
    // []- should keep lights off when button is pressed while doors are open

    Lift lift;

    @BeforeEach
    void setUp() {
        lift = new Lift();

    }

    @Test
    @DisplayName("should switch lights on when button is pressed")
    void should_switch_lights_on_when_button_is_pressed() {

        //when
        lift.pressButton();

        //then
        assertThat(lift.lights())
                .as("Lights should be on")
                .isTrue();
    }

    @Test
    @DisplayName("should switch lights off when doors open")
    void should_switch_lights_off_when_doors_open() {

        //given
        lift.pressButton();

        //when
        lift.doorsOpened();

        //then
        assertThat(lift.lights())
                .as("lights should be off")
                .isFalse();
    }

}
