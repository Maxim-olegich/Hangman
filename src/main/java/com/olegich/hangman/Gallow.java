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
    }

    private String getHangman(int userErrorsCounter) {
        return switch (userErrorsCounter) {
            case 1 -> """
                    |____________
                    |      |
                    |
                    |
                    |
                    |
                    """;
            case 2 -> """
                    |____________
                    |      |
                    |      0
                    |
                    |
                    |
                    """;
            case 3 -> """
                    |____________
                    |      |
                    |      0
                    |      |
                    |
                    |
                    """;
            case 4 -> """
                    |____________
                    |      |
                    |      0
                    |     /|
                    |
                    |
                    """;
            case 5 -> """
                    |____________
                    |      |
                    |      0
                    |     /|\\
                    |
                    |
                    """;
            case 6 -> """
                    |____________
                    |      |
                    |      0
                    |     /|\\
                    |     /
                    |
                    """;
            case 7 -> """
                    |____________
                    |      |
                    |      0
                    |     /|\\
                    |     / \\
                    |
                    """;
            default -> """
                    |____________
                    |
                    |
                    |
                    |
                    |
                    """;
        };
    }
}
