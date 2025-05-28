package com.ibanfr.yatzy;

import org.junit.jupiter.api.Test;

import static com.ibanfr.yatzy.ScoreCalculatorFactory.getScoreCalculator;
import static org.assertj.core.api.Assertions.assertThat;


class ScoreCalculatorFactoryTest {

    //system under test
    ScoreCalculatorFactory factory;

    //TEST LIST
    //[] - should create a new ScoreCalculator instance for the CHANCES Category
    //[] - should create a new ScoreCalculator instance for the YATZY Category


    @Test
    void should_create_a_new_ScoreCalculator_instance_for_the_CHANCES_Category() {

        //when
        ScoreCalculator calculator = getScoreCalculator(YatzyCategory.CHANCES);

        //then
        assertThat(calculator)
                    .isInstanceOf(ChancesScoreCalculator.class);

    }
}