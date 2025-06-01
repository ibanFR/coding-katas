package com.ibanfr.printdiamond;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrintDiamondTest {

    @ParameterizedTest(name = "print diamond for letter {0} should return {1}")
    @CsvSource({
            "A, A",
            "B, '.A.\nB.B'",
            "C, '..A..\n.B.B.\nC...C'",
    })
    void should_print_diamond_for_letter_A(String letter, String expected) {

        //when
        String result = DiamondPrinter.print(letter);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "Find letter position for {0} should return {1}")
    @CsvSource({
            "A, 0",
            "B, 1",
            "C, 2"
    })
    void should_find_letter_position_in_alphabet_for_given_letter(String letter, int expectedPosition) {

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


    @ParameterizedTest(name = "left padding for line {0} when letter is {1} => {2}")
    @CsvSource({
            "1, A, ''",
            "1, B, .",
            "1, C, ..",
            "1, D, ...",
            "2, B, ''",
            "2, C, .",
            "2, D, ..",
    })
    void should_get_left_padding_for_line_when_letter_is(int line, String letter, String expectedResult) {

        //when
        String result = DiamondPrinter.paddingForLineAndLetter(line, letter);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }


    @ParameterizedTest(name = "line {0} for letter {1} should return {2}")
    @CsvSource({
            "1, A, A",
            "1, B, .A.",
            "1, C, ..A..",
            "2, B, B.B",
            "2, C, .B.B.",
            "3, C, C...C",
            "3, D, .C...C.",
    })
    void should_print_given_diamond_line_for_given_letter(int lineNumber, String letter, String expectedResult) {

        //when
        String result = DiamondPrinter.printLineForLetter(lineNumber, letter);

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "middle padding for line {0} should return {1}")
    @CsvSource({
            "2, .",
            "3, ...",
            "4, .....",
            "5, .......",

    })
    void should_add_middle_padding(int lineNumber, String expected) {

        String result = DiamondPrinter.middlePaddingForLine(lineNumber);

        //then
        assertThat(result).isEqualTo(expected);
    }

    // left padding for line 1 AND letter ""
    // left padding for line 2 "."
    // left padding for line 3 ".."
}
