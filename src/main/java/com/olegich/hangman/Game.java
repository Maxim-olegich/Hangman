package com.olegich.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static final int DEAD_LEVEL = 7;
    private static final String MASK_SYMBOL = "_";
    private static final Gallow gallow = new Gallow();
    private final List<String> usedLetters = new ArrayList<>();
    private String hiddenWord;// 'hiddenWord' its underline '______'
    private int userErrorsCounter = 0;

    private enum ErrorMessage {
        WRONG_NUMBER_OF_LETTERS,
        WRONG_TYPE_OF_LETTER,
        LETTER_ALREADY_IN_USE
    }

    public void start(String guessableWord) {
        hiddenWord = MASK_SYMBOL.repeat(guessableWord.length());
        gallow.drawGallow(userErrorsCounter);

        while (hiddenWord.contains(MASK_SYMBOL)) {
            System.out.println();
            if (isDead(userErrorsCounter)) {
                break;
            }

            Scanner scanner = new Scanner(System.in);
            printProgress();
            System.out.print("Input a cyrillic letter: ");
            String letter = scanner.nextLine().toLowerCase();

            if (isInputValid(letter)) {
                String hiddenWordWithGuessedLetters = getGuessedLetters(hiddenWord, guessableWord, letter.charAt(0));
                boolean isUserGuessedLetter = hasUserGuessedLetter(hiddenWordWithGuessedLetters);
                printTurnResults(isUserGuessedLetter);
                usedLetters.add(letter);

                if (isUserGuessedLetter) {
                    updateHiddenWord(hiddenWordWithGuessedLetters);
                } else {
                    userErrorsCounter++;
                    gallow.drawGallow(userErrorsCounter);
                }
            }
        }
        printRoundResult(userErrorsCounter, guessableWord);
    }

    private void printProgress() {
        System.out.println("Progress: " + hiddenWord +
                ". The used letters: " + String.join(", ", usedLetters));
    }

    private boolean isDead(int userErrorsCounter) {
        return userErrorsCounter == DEAD_LEVEL;
    }

    private void updateHiddenWord(String hiddenWordWithGuessedLetters) {
        hiddenWord = hiddenWordWithGuessedLetters;
    }

    private boolean hasUserGuessedLetter(String hiddenWordWithGuessedLetters) {
        return !hiddenWordWithGuessedLetters.equals(hiddenWord);
    }

    private void printTurnResults(boolean isUserGuessedLetter) {
        if (isUserGuessedLetter) {
            System.out.println("Yes! You guessed the letter!");
        } else {
            System.out.println("You didn't guess the letter.");
        }
    }

    private boolean isInputValid(String userInput) {
        if (userInput.length() > 1 || userInput.isBlank()) {
            printInputError(ErrorMessage.WRONG_NUMBER_OF_LETTERS);
            return false;
        }
        if (userInput.charAt(0) < 'а' || userInput.charAt(0) > 'я') {
            printInputError(ErrorMessage.WRONG_TYPE_OF_LETTER);
            return false;
        }
        if (usedLetters.contains(userInput)) {
            printInputError(ErrorMessage.LETTER_ALREADY_IN_USE);
            return false;
        }

        return true;
    }

    private void printInputError(ErrorMessage message) {
        switch (message) {
            case ErrorMessage.WRONG_NUMBER_OF_LETTERS -> System.out.println("[ERROR] Please input only one letter!");
            case ErrorMessage.WRONG_TYPE_OF_LETTER -> System.out.println("[ERROR] Please input a cyrillic letter.");
            default -> System.out.println("[ERROR] You have already used this letter. " +
                    "Please choose another one.");
        }
    }

    private void printRoundResult(int gameScore, String guessedWord) {
        if (gameScore < DEAD_LEVEL) {
            System.out.println("\nThe word was: " + guessedWord +
                    "\nCongrats! You have won this game! ");
        } else {
            System.out.println("\nThe word was: " + guessedWord +
                    "\nSorry. You have lost this game :( ");
        }
    }

    private String getGuessedLetters(String hiddenWord, String word, char letter) {
        StringBuilder result = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                result.setCharAt(i, letter);
            }
        }

        return result.toString();
    }
}