package com.ibanfr.yatzy;

import java.util.Arrays;

public class YatzyScoreCalculator {

    private YatzyScoreCalculator() {
        // Prevent instantiation
    }

    public static int scoreRoll(Roll roll, YatzyCategory category) {
        return Arrays.stream(roll.dice())
                .reduce(0, Integer::sum);
    }
}
