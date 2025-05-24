package com.ibanfr.printdiamond;

import java.util.List;

public class DiamondPrinter {

    public static final List<String> LETTERS = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public static String print(String letter) {
        return "A";
    }

    public static int findLetterPosition(String letter) {

        if (letter.length() != 1) {
            throw new IllegalArgumentException("Input must be one letter");
        }

        return LETTERS.indexOf(letter);
    }

    public static String addLeftPaddingForLetter(String letter, int padding) {

        return ".".repeat(padding) + letter;
    }

    public static String addRightPaddingToString(String string, int padding) {
        return string;
    }
}
