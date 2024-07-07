package com.ibanfr.wonderlandnumber;

// A simple example to get you started
// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WonderlandNumberGeneratorTest {

   
    
    @Test
    void a_wonderland_number_has_six_digits() {
        
        int expected = 6;
        
        WonderlandNumber wonderlandNumber = WonderlandNumberGenerator.generateWonderlandNumber();
        
        // calculate number of digits
        assertEquals(expected, wonderlandNumber.numberOfDigits());
    }
    
    @Test
    void a_wonderland_number_multiplied_by_two_should_have_same_digits_as_the_original_number() {
        
        //given 
        WonderlandNumber wonderlandNumber = WonderlandNumberGenerator.generateWonderlandNumber();
        
        //when
        int resultingNumber = wonderlandNumber.multiplyBy(2);
        
        // then
        assertTrue(wonderlandNumber.hasSameDigitsAs(resultingNumber));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6})
    void a_wonderland_number_multiplied_by_2_3_4_5_6_should_have_same_digits_as_the_original_number(int number) {
        
        //given 
        WonderlandNumber wonderlandNumber = WonderlandNumberGenerator.generateWonderlandNumber();
        
        //when
        int resultingNumber = wonderlandNumber.multiplyBy(number);
        
        // then
        assertTrue(wonderlandNumber.hasSameDigitsAs(resultingNumber));
    }
    
    @Test
    void a_wonderland_number_multiplied_by_7_should_not_have_same_digits_as_the_original_number() {
        
        //given 
        WonderlandNumber wonderlandNumber = WonderlandNumberGenerator.generateWonderlandNumber();
        
        //when
        int resultingNumber = wonderlandNumber.multiplyBy(7);
        
        // then
        assertFalse(wonderlandNumber.hasSameDigitsAs(resultingNumber));
    }
}
