package com.ibanfr.leapyears;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeapYearCalcTest {


    //TEST LIST
    // [X] - leap year is divisible by 4
    // [X] - leap year is divisible by 4 but not by 100
    // [] - leap year is divisible by 4 and 100 and 400
    // [] - 1996 is a typical leap year
    // [] - 2000 is an atypical leap year
    // [] - 2001 is a typical common year
    // [] - 1900 is an atypical common year


    @Test
    void leap_year_is_divisible_by_4() {

        boolean isLeapYear = LeapYearCalculator.isLeapYear(4);

        assertThat(isLeapYear)
                .isTrue();
    }

    @Test
    void leap_year_is_divisible_by_4_but_not_by_100() {

        boolean isLeapYear = LeapYearCalculator.isLeapYear(100);

        assertThat(isLeapYear)
                .isFalse();
    }
}
