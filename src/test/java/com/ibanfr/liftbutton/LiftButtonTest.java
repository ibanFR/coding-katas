package com.ibanfr.liftbutton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ibanfr.liftbutton.LiftDoorStatus.CLOSED;
import static org.assertj.core.api.Assertions.assertThat;

class LiftButtonTest {

    // TEST LIST
    // [X]- should switch lights on when button is pressed
    // [X] - should close the doors when button is pressed
    // [X] - should open the doors when lift arrives
    // [X]- should switch lights off when doors open
    // [X]- should keep lights on when button is pressed while doors are closed
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
    @DisplayName("should close the doors when button is pressed")
    void should_close_the_doors_when_button_is_pressed() {

        //when
        lift.pressButton();

        //then
        assertThat(lift.doors())
                .as("doors should be CLOSED")
                .isEqualTo(CLOSED);
    }

    @Test
    @DisplayName("should open the doors when lift arrives")
    void should_open_the_doors_when_lift_arrives() {

        //given
        lift.pressButton();

        //when
        lift.arrived();

        //then
        assertThat(lift.doors())
                .as("doors should be OPEN")
                .isEqualTo(LiftDoorStatus.OPEN);
    }

    @Test
    @DisplayName("should switch lights off when doors open")
    void should_switch_lights_off_when_doors_open() {

        //given
        lift.pressButton();

        //when
        lift.arrived();

        //then
        assertThat(lift.lights())
                .as("lights should be off")
                .isFalse();
    }

    @Test
    @DisplayName("should keep lights on when button is pressed while doors are closed")
    void should_keep_lights_on_when_button_is_pressed_while_doors_are_closed() {

        //given
        lift.pressButton();

        //when
        lift.pressButton();

        //then
        assertThat(lift.lights())
                .as("lights should be on")
                .isTrue();
    }

    @Test
    @DisplayName("should keep lights off when button is pressed while doors are open")
    @Disabled
    void should_keep_lights_off_when_button_is_pressed_while_doors_are_open() {

        //given button pressed
        lift.pressButton();
        //given lift arrived and doors opened
        lift.arrived();

        //when
        lift.pressButton();

        //then
        assertThat(lift.lights())
                .as("lights should be off")
                .isFalse();
    }

}
