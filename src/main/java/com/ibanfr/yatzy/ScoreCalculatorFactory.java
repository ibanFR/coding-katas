package com.ibanfr.yatzy;

public class ScoreCalculatorFactory {

    private ScoreCalculatorFactory(){
        //private constructor to hide implicit one
    }

    public static ScoreCalculator getScoreCalculator(YatzyCategory category) {

        ScoreCalculator calculator;
        switch (category){
            case CHANCES -> calculator = new ChancesScoreCalculator();
            default -> calculator = null;
        }

        return calculator;
    }
}
