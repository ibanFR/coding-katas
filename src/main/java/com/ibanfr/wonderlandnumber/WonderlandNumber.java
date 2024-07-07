package com.ibanfr.wonderlandnumber;

import java.util.List;
import java.util.Arrays;

public class WonderlandNumber {
    
    private Integer wonderlandNumber;
    
    
    public WonderlandNumber(){     
        this.wonderlandNumber = Integer.valueOf(142857);
        
    }

    public int numberOfDigits(){    
        return String.valueOf(wonderlandNumber).length();
    }
    
    public int multiplyBy(int times){  
        return wonderlandNumber * times;
    }
    
    /**
     * compare digits of two int numbers
     *   
     */
    public boolean hasSameDigitsAs(int otherNumber){
       
        List<String> digitsOtherNumber = extractDigits(otherNumber);
        
        return extractDigits(wonderlandNumber).containsAll(digitsOtherNumber);
    }
    
    private List<String> extractDigits(int number){
        
        String numberAsString = String.valueOf(number);
        String[] digits = numberAsString.split("");
        
        return Arrays.asList(digits);
    }
}
