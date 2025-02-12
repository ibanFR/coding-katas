package com.ibanfr.shoppingbasket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class is used to test the binary floating point arithmetics.
 * <p>
 * Floats (float) and doubles (double) are not suitable for handling money in Java because they use binary
 * floating-point arithmetic, which can lead to precision errors.
 * <p>
 * Floats and doubles represent numbers in binary (base-2) format, while monetary values are typically represented in
 * decimal (base-10).
 * <p>
 * Certain decimal values (e.g., 0.1, 0.2) cannot be represented exactly in binary, leading to small rounding errors.
 */
class BinaryFloatingPointArithmeticsTest {


    @Nested
    @DisplayName("Rounding Errors in calculations")
    class RoundingErrorsInCalculations {

        @Test
        @DisplayName("should not be equal to 0.3")
        void should_not_be_equal_to_03(){

            //when
            double result = 0.1 + 0.2;

            //then
            assertThat(result)
                    .isNotEqualTo(0.3)
                    .isEqualTo(0.30000000000000004);
        }

        @Test
        @DisplayName("should not be equal to 0.9")
        void should_not_be_equal_to_09() {

            //when
            double result = 2.0 - 1.1;

            //then
            assertThat(result)
                    .isNotEqualTo(0.9)
                    .isEqualTo(0.8999999999999999);
        }

        @Test
        @DisplayName("should be equal to 0.3 when using BigDecimal")
        void should_be_equal_when_using_big_decimal() {

            //when
            BigDecimal result = BigDecimal.valueOf(0.1)
                    .add(BigDecimal.valueOf(0.2));

            //then
            assertThat(result)
                    .isEqualTo("0.3");
        }

    }

}
