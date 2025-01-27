package com.ibanfr.liftbutton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LiftButtonTest {

    // TEST LIST
    // [X]- should switch lights on when button is pressed
    // []- should switch lights off when doors open
    // []- should keep lights on when button is pressed while doors are closed
    // []- should keep lights off when button is pressed while doors are open

    @Test
    @DisplayName("should switch lights on when button is pressed")
    void should_switch_lights_on_when_button_is_pressed() {

        //given
        Lift lift = new Lift();

        //when
        lift.pressButton();

        //then
        assertThat(lift.lights())
                .as("Lights should be on")
                .isTrue();
    }

}
