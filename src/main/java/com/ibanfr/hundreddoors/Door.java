package com.ibanfr.hundreddoors;

public class Door {
    
    boolean isOpen = false;
    
    protected Door(){
    }
    
    protected Door(boolean isOpen){
        this.isOpen=isOpen;
    }
    
    
    public boolean isOpen(){
        return isOpen;
    }
    
    public void pass(){
        isOpen = !isOpen;
    }
    
    public String toString(){
     
        return "Door[isOpen="+isOpen+"]";
    }
    
}