package com.ibanfr.hundreddoors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Door100App {
    
    List<Door> doors;
    
    public Door100App(){
        this(100);
    }
    
    protected Door100App(int doors){
        this.doors = IntStream.range(0,doors)
            .mapToObj(i -> new Door())
            .collect(Collectors.toList());
    }
    
    public void passDoors(int times){
        for(int i=1;i<=times;i++)
            visitEveryDoor(i);           
    }
    
    private void visitEveryDoor(int door){
        for(int i=1;i<=doors.size();i++){  
            if(i%door==0)
                doors.get(i-1).pass();
        }  
    }
    
    public String answer() {
        
        return "Open doors: "+IntStream.rangeClosed(1, doors.size())
            .filter(i->doors.get(i-1).isOpen())
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(", "));
    }
}
