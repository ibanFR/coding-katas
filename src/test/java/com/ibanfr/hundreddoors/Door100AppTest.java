package com.ibanfr.hundreddoors;

import org.junit.jupiter.api.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class Door100AppTest {



    Door100App app;
    
    @BeforeEach
    void setUp(){
        app = new Door100App(100);
    }
    
    @Test
    @Disabled
    void should_create_a_list_of_hundred_doors(){
        
        List<Door> doors = IntStream.range(0,100)
            .mapToObj(i -> new Door())
            .collect(Collectors.toList());
        
        assertEquals(100, doors.size());
    }
    
    @Test
    @Disabled
    void should_all_be_open_in_the_first_pass() {
        //String expected = "[Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true], Door[isOpen=true]]";
       
        List<Door> expectedDoors = List.of(new Door(true),new Door(true), 
                                           new Door(true), new Door(true), 
                                           new Door(true),new Door(true), 
                                           new Door(true), new Door(true), 
                                           new Door(true), new Door(true));
        
        app.passDoors(1);
        
        assertEquals(expectedDoors.toString(), app.answer());
    }
    
    //write a test that verifies two passess against a list of doors
    // the expected list need to be created
    @Test
    @Disabled
    void should_return_the_expected_list_after_two_passess(){
       
        List<Door> expectedDoors = List.of(new Door(true),new Door(false), 
                                           new Door(true), new Door(false), 
                                           new Door(true),new Door(false), 
                                           new Door(true), new Door(false), 
                                           new Door(true), new Door(false));
        
        app.passDoors(2);
        
        assertEquals(expectedDoors.toString(),app.answer());
    }
    
    @Test
    @Disabled
    void should_return_the_expected_list_after_three_passess(){
       
        List<Door> expectedDoors = List.of(new Door(true),new Door(false), 
                                           new Door(false), new Door(false), 
                                           new Door(true),new Door(true), 
                                           new Door(true), new Door(false), 
                                           new Door(false), new Door(false));
        
        app.passDoors(3);
        
        assertEquals(expectedDoors.toString(),app.answer());
    }
    
    @Test
    void should_return_the_expected_list_after_hundred_passess(){
        
        String expected = "Open doors: 1, 4, 9, 16, 25, 36, 49, 64, 81, 100";
        
        app.passDoors(100);
        
        assertEquals(expected, app.answer());
    }
    
    
    
    
   
}
