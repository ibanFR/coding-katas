package com.ibanfr.yatzy;

import java.util.Arrays;

public class YatzyScoreCalculator {

    private YatzyScoreCalculator() {
        // Prevent instantiation
    }

    public static int scoreRoll(Roll roll, YatzyCategory category) {

        ScoreCalculator calculator = ScoreCalculatorFactory.getScoreCalculator(category);

        if (category == YatzyCategory.CHANCES) {
            return scoreChances(roll);
        } else if (category == YatzyCategory.YATZY) {
            return scoreYatzy(roll);
        }else{
            throw new IllegalArgumentException("Unknown category: " + category);
        }

    }

    private static int scoreYatzy(Roll roll) {
        return areAllDiceEqual(roll)?50:0;
    }

    private static boolean areAllDiceEqual(Roll roll) {
        return Arrays.stream(roll.dice())
                .allMatch(value -> value == roll.dice()[0]);
    }

    private static int scoreChances(Roll roll) {
        return Arrays.stream(roll.dice())
                .reduce(0, Integer::sum);
    }
}
