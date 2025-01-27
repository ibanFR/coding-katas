package com.ibanfr.liftbutton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.ibanfr.liftbutton.LiftDoorStatus.CLOSED;
import static org.assertj.core.api.Assertions.assertThat;

class LiftButtonTest {

    // system under test
    Lift lift;

    @BeforeEach
    void setUp() {
        lift = new Lift();
    }

    @Test
    @DisplayName("should close the lift doors ")
    void should_close_the_lift_doors() {

        //when
        lift.closeDoors();

        //then
        assertThat(lift.doors())
                .as("doors should be CLOSED")
                .isEqualTo(CLOSED);
    }

    @Test
    @DisplayName("should switch lights ON when button is pressed")
    void should_switch_lights_on_when_button_is_pressed() {

        //when
        lift.pressButton();

        //then
        assertThat(lift.lights())
                .as("Lights should be ON")
                .isEqualTo(LiftLampStatus.ON);
    }

    @Test
    @DisplayName("should open the doors when lift arrives")
    void should_open_the_doors_when_lift_arrives() {

        //given
        lift.closeDoors();

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
                .as("lights should be OFF")
                .isEqualTo(LiftLampStatus.OFF);
    }

    @Test
    @DisplayName("should keep lights on when button is pressed while doors are closed")
    void should_keep_lights_on_when_button_is_pressed_while_doors_are_closed() {

        //given
        lift.closeDoors();

        //when
        lift.pressButton();

        //then
        assertThat(lift.lights())
                .as("lights should be ON")
                .isEqualTo(LiftLampStatus.ON);
    }

    @Test
    @DisplayName("should keep lights off when button is pressed while doors are open")
    void should_keep_lights_off_when_button_is_pressed_while_doors_are_open() {

        //given doors are closed
        lift.closeDoors();

        //given lift arrives and doors open
        lift.arrived();

        //when
        lift.pressButton();

        //then
        assertThat(lift.lights())
                .as("lights should be OFF")
                .isEqualTo(LiftLampStatus.OFF);
    }

}
