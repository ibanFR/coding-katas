package com.ibanfr.printdiamond;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrintDiamondTest {

    //TEST LIST
    // [X] - Print diamond for 'A'
    // [X] - Find letter position for 'A' should return 0
    // [X] - Find letter position for 'B' should return 1
    // [X] - Find letter position for 'C' should return 2
    // [X] - find letter position for 'AA' should return an exception

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

    @ParameterizedTest
    @CsvSource({
            "A, 0",
            "B, 1",
            "C, 2"
    })
    @DisplayName("Find letter position for 'A' should return 0")
    void Find_letter_position_for_A_should_return_0(String letter, int expectedPosition) {

        //when
        int position = DiamondPrinter.findLetterPosition(letter);

        //then
        assertThat(position).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("find letter position should only accept one letter")
    void find_letter_position_should_only_accept_one_letter() {

        //then
        assertThatThrownBy(() -> DiamondPrinter.findLetterPosition("AA"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Input must be one letter");
    }

    @ParameterizedTest(name = "should add {1} left padding for letter {0} => {2}")
    @CsvSource({
            "A, 0, A",
            "A, 1, .A",
            "A, 2, ..A",
            "A, 3, ...A"
    })
    void should_add_left_padding_for_letter(String letter, int padding, String expectedResult) {

        //when
        String result = DiamondPrinter.addLeftPaddingForLetter(letter, padding);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }


    @ParameterizedTest(name = "should add {1} right padding to string {0} => {2}")
    @CsvSource({
            "A, 0, A",
            ".A, 1, .A.",
            "..A, 2, ..A..",
            "...A, 3, ...A..."
    })
    void should_add_right_padding_to_String(String string, int padding, String expectedResult) {

        //when
        String result = DiamondPrinter.addRightPaddingToString(string, padding);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    //[] - print line '1' when letter is 'A' => "A"
    //[] - print line '1' when letter is 'B' => ".A."
    //[] - print line '1' when letter is 'C' => "..A.."

}
