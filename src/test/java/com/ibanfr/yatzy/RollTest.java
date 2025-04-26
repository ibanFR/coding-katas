package com.ibanfr.yatzy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RollTest {

    // system under test
    Roll roll;

    @Test
    void should_contain_max_5_dice() {
        //then
        assertThatThrownBy(() -> new Roll(1, 2, 3, 4, 5, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Roll must contain max 5 dice");

    }


    @Test
    void a_die_should_be_a_number_between_1_and_6() {

        //then
        assertThatThrownBy(() -> new Roll(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Each die must have a value between 1 and 6");

    }


}