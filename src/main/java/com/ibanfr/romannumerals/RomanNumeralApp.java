package com.ibanfr.romannumerals;

import java.util.stream.IntStream;

public class RomanNumeralApp {

    public static String romanNumeral(Integer number) {
        
       String[] symbols = new String[]{"I","V","X","L","C", "D", "M"};
        
        // multiple of 10
        String units = "I";
        String fives= "V";
        String tens = "X";
        
        // Convert the integer to a string
        String numberString = String.valueOf(number);

        // Split the string into individual digit strings
        String[] digits = numberString.split("");
        
        String romanNumeral="";
        
       
        for (int index=0; index<digits.length; index++) {
                
            Integer digit = Integer.valueOf(digits[index]);
            
            switch(digits.length-index){
                case 2: //DECIMALS
                    romanNumeral += digitToRomanNumeral(digit, "X", "L", "C"); 
                    break;
                case 3: // HUNDREDS
                    romanNumeral += digitToRomanNumeral(digit, "C", "D", "M"); 
                    break;
                case 4: //THOUSANDS
                    romanNumeral += thousandsToRomanNumerals(digit); 
                    break;
                    /*
                default: 
                    romanNumeral= digitToRomanNumeral(digit, units, fives, tens); 
                    break; */
            }
            
        }
        romanNumeral+= digitToRomanNumeral(Integer.valueOf(digits[digits.length-1]), units, fives, tens);
        
        
        return romanNumeral;
      
    }
    
    private static String thousandsToRomanNumerals(int digit){
        return repeatSymbol("M", digit);
        
    }
    
    
    private static String digitToRomanNumeral(int digit, String units, String fives, String tens){
        
        String romanNumeral="";
        
        switch (digit) {
            case 1,2,3: romanNumeral = repeatSymbol(units, digit); break;
            case 4:  romanNumeral = units+fives; break;
            case 5:  romanNumeral= fives; break;
            case 6,7,8:  romanNumeral= fives+repeatSymbol(units, digit%5); break;
            case 9:  romanNumeral= units+tens; break;
            default: romanNumeral= ""; break;
        }
        
        //System.out.println("digit=> "+digit+", romanNumeral=>"+romanNumeral);
        
        return romanNumeral;
    }
  
    
    private static String repeatSymbol(String symbol, int times) {
        return IntStream.range(0, times)
                        .mapToObj(i -> symbol)
                        .reduce("", String::concat);
    }
}
