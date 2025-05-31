package com.ibanfr.printdiamond;

import java.util.List;

public class DiamondPrinter {

    private DiamondPrinter() {
        // Prevent instantiation
    }

    public static final List<String> LETTERS = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public static String print(String letter) {
        return printLineForLetter(1,letter);
    }

    public static int findLetterPosition(String letter) {

        if (letter.length() != 1) {
            throw new IllegalArgumentException("Input must be one letter");
        }

        return LETTERS.indexOf(letter);
    }


    public static String paddingForLineAndLetter(int line, String letter) {

        if (line == 1) {
            return ".".repeat(findLetterPosition(letter));
        }else{
            return paddingForLineAndLetter(line - 1, letter).substring(1);
        }
    }

    public static String printLineForLetter(int lineNumber, String letter) {

        String letterForLine = getLetterForLine(lineNumber);
        String padding = paddingForLineAndLetter(lineNumber, letter);

        if (lineNumber == 1) {
            return padding + letterForLine + padding;
        }else {
            return padding + letterForLine + middlePaddingForLine(lineNumber) + letterForLine + padding;
        }

    }

    private static String getLetterForLine(int lineNumber) {
        return LETTERS.get(lineNumber - 1);
    }

    public static String middlePaddingForLine(int lineNumber) {

        if (lineNumber == 1) {
            return "";
        }else if (lineNumber == 2) {
            return ".";
        }else {
            return middlePaddingForLine(lineNumber - 1) + "..";
        }

    }
}
