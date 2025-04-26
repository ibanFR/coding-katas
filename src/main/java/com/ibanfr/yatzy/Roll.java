package com.ibanfr.yatzy;

import java.util.Arrays;

public record Roll(int... dice) {

    public Roll {
        if (dice.length > 5) {
            throw new IllegalArgumentException("Roll must contain max 5 dices");
        }
        if (Arrays.stream(dice).anyMatch(die -> die < 1 || die > 6)) {
            throw new IllegalArgumentException("Each die must have a value between 1 and 6");
        }
    }


}
