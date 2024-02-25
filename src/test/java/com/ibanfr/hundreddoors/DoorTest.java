package com.ibanfr.hundreddoors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

class DoorTest {
    
    
    Door door = new Door();
    
    @Test
    void door_is_initially_closed(){
        assertEquals(door.isOpen(), false);
    }
    
    @Test
    void should_open_the_door_when_user_pass_the_door(){
        //when
        door.pass();
        
        //then
        assertEquals(door.isOpen(), true);
        assertEquals("Door[isOpen=true]", door.toString());
        
    }
    
    @Test
    void should_print_the_door_state(){
        String expected = "Door[isOpen=false]";
            
        assertEquals(expected,door.toString());            
    }
    
    @Test
    void should_print_the_door_state_for_100_doors(){
        String expected = "[Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false], Door[isOpen=false]]";
        
        List<Door> doors = Collections.nCopies(100, new Door());
        
        //System.out.println(doors);
            
        assertEquals(expected,doors.toString());            
    }
    
    

}