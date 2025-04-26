package com.ibanfr.yatzy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class YatzyScoreCalculatorTest {

    // system under test
    YatzyScoreCalculator calculator;

    // TEST LIST: Your task is to score a GIVEN roll in a GIVEN category.

    @Nested
    class Chances_Category {

        public static Stream<Arguments> provideChancesCategoryTestData() {
            return Stream.of(Arguments.of(new int[]{1, 1, 3, 3, 6}, 14),
                             Arguments.of(new int[]{4, 5, 5, 6, 1}, 21));
        }

        @ParameterizedTest
        @MethodSource("provideChancesCategoryTestData")
        @DisplayName("should score the sum of all dice")
        void should_score_the_sum_of_all_dice(int[] dice, int expectedScore) {

            //given
            Roll roll = new Roll(dice);

            //when
            int score = YatzyScoreCalculator.scoreRoll(roll, YatzyCategory.CHANCES);

            //then
            assertThat(score)
                    .as("score should be %d", expectedScore)
                    .isEqualTo(expectedScore);
        }


    }

    @Nested
    class Yatzy_Category {

        // should score 50 if all dice have the same number
        @Test
        void should_score_50_if_all_dice_have_the_same_number() {
            //given
            Roll roll = new Roll(1,1,1,1,1);
            int expectedScore= 50;

            //when
            int score = YatzyScoreCalculator.scoreRoll(roll, YatzyCategory.YATZY);

            //then
            assertThat(score)
                    .as("score should be %d", expectedScore)
                    .isEqualTo(expectedScore);

        }


        @Test
        void should_score_0_if_all_dice_do_not_have_the_same_number() {
            //given
            Roll roll = new Roll(1,1,1,1,2);
            int expectedScore= 0;

            //when
            int score = YatzyScoreCalculator.scoreRoll(roll, YatzyCategory.YATZY);

            //then
            assertThat(score)
                    .as("score should be %d", expectedScore)
                    .isEqualTo(expectedScore);

        }



    }


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
