package com.ibanfr.leapyears;

public class LeapYearCalculator {


    public static boolean isLeapYear(int year) {
        return year % 4 == 0 &&
                year % 100 != 0;
    }
}
