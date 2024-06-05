package com.olegich.hangman;

public class Gallow {
    public void drawGallow(int userErrorsCounter) {
        /*
        |____________
        |      |
        |      0
        |     /|\
        |     / \
        |
         */

        System.out.print(getHangman(userErrorsCounter));
//
//        System.out.println("|____________");
//        if (userErrorsCounter > 0) {
//            System.out.println("|      |");
//        } else {
//            System.out.println("|      ");
//        }
//
//        if (userErrorsCounter > 1) {
//            System.out.println("|      0");
//        } else {
//            System.out.println("|      ");
//        }
//
//        if (userErrorsCounter > 4) {
//            System.out.println("|     /|\\");
//        } else if (userErrorsCounter > 3) {
//            System.out.println("|     /|");
//        } else if (userErrorsCounter > 2) {
//            System.out.println("|      |");
//        } else {
//            System.out.println("|      ");
//        }
//
//
//        if (userErrorsCounter > 6) {
//            System.out.println("|     / \\");
//        } else if (userErrorsCounter > 5) {
//            System.out.println("|     / ");
//        } else {
//            System.out.println("|      ");
//        }
//
//        System.out.println("|");
    }

    public String getHangman(int userErrorsCounter) {
        switch (userErrorsCounter) {
            case 1:
                return """
                        |____________
                        |      |
                        |
                        |
                        |
                        |
                        """;
            case 2:
                return """
                        |____________
                        |      |
                        |      0
                        |
                        |
                        |
                        """;
            case 3:
                return """
                        |____________
                        |      |
                        |      0
                        |      |
                        |
                        |
                        """;
            case 4:
                return """
                        |____________
                        |      |
                        |      0
                        |     /|
                        |
                        |
                        """;
            case 5:
                return """
                        |____________
                        |      |
                        |      0
                        |     /|\\
                        |
                        |
                        """;
            case 6:
                return """
                        |____________
                        |      |
                        |      0
                        |     /|\\
                        |     /
                        |
                        """;
            case 7:
                return """
                        |____________
                        |      |
                        |      0
                        |     /|\\
                        |     / \\
                        |
                        """;
            default:
                return """
                        |____________
                        |
                        |
                        |
                        |
                        |
                        """;
        }
    }
}
