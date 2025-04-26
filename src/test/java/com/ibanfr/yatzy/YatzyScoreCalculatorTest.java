package com.ibanfr.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YatzyScoreCalculatorTest {

    // system under test
    YatzyScoreCalculator calculator;

    // TEST LIST: Your task is to score a GIVEN roll in a GIVEN category.

    // Chances Category
    // - The player scores the sum of all dice.
    //[X] - A roll of 1,1,3,3,6 in the should score 14
    //[] - A roll of 4,5,5,6,1 in the should score 21

    @Nested
    @DisplayName("Chances Category")
    class Chances_Category {

        @Test
        @DisplayName("should score the sum of all dice")
        void should_score_the_sum_of_all_dice() {

            //given
            int expectedScore = 14;
            Roll roll = new Roll(1, 1, 3, 3, 6);

            //when
            int score = YatzyScoreCalculator.scoreRoll(roll, YatzyCategory.CHANCES);

            //then
            assertThat(score)
                    .as("sum should be %d", expectedScore)
                    .isEqualTo(expectedScore);
        }


    }

    // Yatzy Category
    // - If all dice have the same number, the player scores 50 points.
    //[] - A roll of 1,1,1,1,1 in the should score 50
    //[] - A roll of 2,2,2,2,2 in the should score 50
    //[] - A roll of 1,2,3,4,5 in the should score 0
    //Ones, Twos, Threes, Fours, Fives, Sixes Category
    // - The player scores the sum of the dice that show the given number.
    //[] - A roll of 3,3,3,4,5 in the "Ones" should score 0
    //[] - A roll of 1,2,3,3,6 in the "Ones" should score 1
    //[] - A roll of 1,1,1,3,6 in the "Ones" should score 3
    //Pair Category
    // - The player scores the sum of the two highest matching dice.
    //[] - A roll of 1,2,3,4,5 scores 0
    //[] - A roll of 3,3,3,4,4 scores 8 (4+4)
    //[] - A roll of 3,3,3,4,1 scores 6 (3+3)
    //[] - A roll of 3,3,3,3,1 scores 6 (3+3)
    //[] - should find matching pairs
    //[] - A roll of 1,1,2,2,3 should return [1,2]
    //[] - A roll of 1,1,6,2,6 should return [1,6]





}
