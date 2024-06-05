package com.olegich.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final List<String> usedLetters = new ArrayList<>();
    private static final Gallow gallow = new Gallow();
    private String hiddenWord;// 'hiddenWord' its underline '______'
    private int userErrorsCounter = 0;

    public void start(String guessedWord) {
        hiddenWord = "_".repeat(guessedWord.length());
        gallow.drawGallow(userErrorsCounter);

        while (hiddenWord.contains("_")) {
            System.out.println();
            if (userErrorsCounter == 7) {
                break;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Progress: " + hiddenWord + ". Input a cyrillic letter: ");
            String letter = scanner.nextLine().toLowerCase();
            if (isInputValid(letter)) {
                printTurnResults(guessedWord, letter.charAt(0));
                usedLetters.add(letter);
            }
        }
        printRoundResult(userErrorsCounter, guessedWord);
    }

    public void printTurnResults(String guessedWord, char letter) {
        String wordWithGuessedLetters =
                getGuessedLetters(hiddenWord, guessedWord, letter);

        if (wordWithGuessedLetters.compareTo(hiddenWord) == 0) {
            System.out.println("You didn't guess the letter.");
            userErrorsCounter += 1;
            gallow.drawGallow(userErrorsCounter);
        } else {
            System.out.println("Yes! You guessed the letter!");
            hiddenWord = wordWithGuessedLetters;
        }
    }

    public boolean isInputValid(String userInput) {
        if (userInput.length() > 1 || userInput.isBlank()) {
            System.out.println("[ERROR] Please input only one letter!");
            return false;
        }
        if (userInput.charAt(0) < 'а' || userInput.charAt(0) > 'я') {
            System.out.println("[ERROR] Please input a cyrillic letter.");
            return false;
        }
        if (usedLetters.contains(userInput)) {
            System.out.println("[ERROR] You have already used this letter. " +
                    "Please choose another one.");
            return false;
        }

        return true;
    }

    public void printRoundResult(int gameScore, String guessedWord) {
        if (gameScore < 7) System.out.println("\nThe word was: " + guessedWord +
                "\nCongrats! You have won this game! ");
        else {
            System.out.println("\nThe word was: " + guessedWord +
                    "\nSorry. You have lost this game :( ");
        }
    }

    public String getGuessedLetters(String hiddenWord, String word, char letter) {
        StringBuilder result = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                result.setCharAt(i, letter);
            }
        }

        return result.toString();
    }
}