package com.ibanfr.romannumerals;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RomanNumeralTest {
    
    @Test
    void roman_numeral_1() {
        String expected = "I";
        Integer number = 1;
        String romanNumeral = RomanNumeralApp.romanNumeral(number);
        assertEquals(expected, romanNumeral);
    }
    
    @ParameterizedTest
    @CsvSource({
        "1, I",
        "2, II",
        "3, III",
        "4, IV",
        "5, V",
        "6, VI",
        "7, VII",
        "8, VIII",
        "9, IX"
    })
    void roman_numeral_2_to_9(Integer number, String expectedRomanNumeral) {
        String romanNumeral = RomanNumeralApp.romanNumeral(number);
        assertEquals(expectedRomanNumeral, romanNumeral);
    }
    
    @ParameterizedTest
    @CsvSource({
        "11, XI",
        "12, XII",
        "13, XIII",
        "14, XIV",
        "15, XV",
        "16, XVI",
        "17, XVII",
        "18, XVIII",
        "19, XIX"
    })
    void roman_numeral_10_to_20(Integer number, String expectedRomanNumeral) {
        String romanNumeral = RomanNumeralApp.romanNumeral(number);
        assertEquals(expectedRomanNumeral, romanNumeral);
    }
    
    @ParameterizedTest
    @CsvSource({
        "10, X",
        "20, XX",
        "30, XXX",
        "40, XL",
        "50, L",
        "60, LX",
        "70, LXX",
        "80, LXXX",
        "90, XC"
    })
    void roman_numeral_10_20_30_40_50_60_70_80_90(Integer number, String expectedRomanNumeral) {
        String romanNumeral = RomanNumeralApp.romanNumeral(number);
        assertEquals(expectedRomanNumeral, romanNumeral);
    }
    
    @ParameterizedTest
    @CsvSource({
        "100, C",
        "200, CC",
        "300, CCC",
        "400, CD",
        "500, D",
        "600, DC",
        "700, DCC",
        "800, DCCC",
        "900, CM"
    })
    void roman_numeral_100_200_300_400_500_600_700_800_900(Integer number, String expectedRomanNumeral) {
        String romanNumeral = RomanNumeralApp.romanNumeral(number);
        assertEquals(expectedRomanNumeral, romanNumeral);
    }

    @ParameterizedTest
    @CsvSource({
        "1000, M",
        "2000, MM",
        "3000, MMM",
        "4000, MMMM"
    })
    void roman_numeral_1000_2000_3000_4000(Integer number, String expectedRomanNumeral) {
        String romanNumeral = RomanNumeralApp.romanNumeral(number);
        assertEquals(expectedRomanNumeral, romanNumeral);
    }
    
    @ParameterizedTest
    @CsvSource({
        "1990, MCMXC",
        "2008, MMVIII",
        "99, XCIX",
        "47, XLVII"
    })
    void roman_numeral_1990_2008_99_47(Integer number, String expectedRomanNumeral) {
        String romanNumeral = RomanNumeralApp.romanNumeral(number);
        assertEquals(expectedRomanNumeral, romanNumeral);
    }
}
