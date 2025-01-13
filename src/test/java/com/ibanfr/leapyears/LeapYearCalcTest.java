package com.ibanfr.leapyears;

import org.junit.jupiter.api.Test;

import static com.ibanfr.leapyears.LeapYearCalculator.isLeapYear;
import static org.assertj.core.api.Assertions.assertThat;

class LeapYearCalcTest {

    @Test
    void leap_year_is_divisible_by_4() {
        assertThat(isLeapYear(4))
                .isTrue();
    }

    @Test
    void leap_year_is_divisible_by_4_but_not_by_100() {

        assertThat(isLeapYear(100))
                .isFalse();
    }

    @Test
    void leap_year_is_divisible_by_4_and_100_and_400() {

        assertThat(isLeapYear(400))
                .isTrue();
    }

    @Test
    void a_typical_leap_year_is_1996() {
        assertThat(isLeapYear(1996))
                .isTrue();
    }

    @Test
    void a_non_typical_leap_year_is_2000() {
        assertThat(isLeapYear(2000))
                .isTrue();
    }

    @Test
    void a_typical_common_year() {
        assertThat(isLeapYear(2001))
                .isFalse();
    }

    @Test
    void an_atypical_common_year() {
        assertThat(isLeapYear(1900))
                .isFalse();
    }
}
