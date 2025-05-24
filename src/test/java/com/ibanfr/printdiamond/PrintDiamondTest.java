package com.ibanfr.printdiamond;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrintDiamondTest {

    //TEST LIST
    // [X] - Print diamond for 'A'
    // [] - Find letter position for 'A'
    // [] - Find letter position for 'B'
    // [] - Find letter position for 'C'

    @Test
    @DisplayName("should print diamond for letter A")
    void should_print_diamond_for_letter_A() {

        //given
        String expected = "A";

        //when
        String result = DiamondPrinter.print("A");

        //then
        assertThat(result).isEqualTo(expected);
    }
}
