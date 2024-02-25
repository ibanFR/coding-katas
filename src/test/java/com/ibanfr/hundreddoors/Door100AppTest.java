package com.ibanfr.hundreddoors;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Door100AppTest {

    Door100App app;
    
    @Test
    void should_all_be_open_in_the_first_pass() {

        String expected = "Open doors: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10";

        //given
        app = new Door100App(10);
        //when
        app.passDoors(1);
        //then
        assertEquals(expected, app.answer());
    }
    
    //write a test that verifies two passess against a list of doors
    // the expected list need to be created
    @Test
    void should_return_the_expected_list_after_two_passes(){

        String expected = "Open doors: 1, 3, 5, 7, 9";

        //given
        app = new Door100App(10);
        //when
        app.passDoors(2);
        //then
        assertEquals(expected,app.answer());
    }
    
    @Test
    void should_return_the_expected_list_after_three_passes(){

        String expected = "Open doors: 1, 5, 6, 7";
        //given
        app = new Door100App(10);
        //when
        app.passDoors(3);
        //then
        assertEquals(expected,app.answer());
    }
    
    @Test
    void should_return_the_expected_list_after_hundred_passes(){
        
        String expected = "Open doors: 1, 4, 9, 16, 25, 36, 49, 64, 81, 100";
        //given
        app = new Door100App(100);
        //when
        app.passDoors(100);
        //then
        assertEquals(expected, app.answer());
    }
    
    
    
    
   
}
