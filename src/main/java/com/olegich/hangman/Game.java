package com.olegich.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final List<String> usedLetters = new ArrayList<>();
    private static final Gallow gallow = new Gallow();
    private StringBuilder hiddenWord;// 'hiddenWord' its underline '______'
    private int userErrorsCounter = 0;

    public void startGame(String guessedWord) {
        hiddenWord = getHiddenWord(guessedWord.length());
        gallow.drawGallow(userErrorsCounter);

        while (hiddenWord.indexOf("_") != -1) {
            System.out.println();
            if (userErrorsCounter == 7) {
                break;
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Progress: " + hiddenWord + ". Input a cyrillic letter: ");
            String letter = scanner.nextLine().toLowerCase();
            if (checkUserInput(letter)) {
                printTurnResults(guessedWord, letter.toCharArray()[0]);
            }
        }
        printRoundResult(userErrorsCounter, guessedWord);
    }

    public void printTurnResults(String guessedWord, char letter) {
        StringBuilder wordWithGuessedLetters =
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

    public boolean checkUserInput(String userInput) {
        if (userInput.length() > 1 || userInput.isBlank()) {
            System.out.println("[ERROR] Please input only one letter!");
            return false;
        }
        if (!(userInput.charAt(0) >= 'а' && userInput.charAt(0) <= 'я')) {
            System.out.println("[ERROR] Please input a cyrillic letter.");
            return false;
        }
        if (usedLetters.contains(userInput)) {
            System.out.println("[ERROR] You have already used this letter. " +
                    "Please choose another one.");
            return false;
        }

        usedLetters.add(userInput);
        return true;
    }

    public void printRoundResult(int gameScore, String guessedWord) {
        if (gameScore < 7) System.out.println("\nCongrats! You have won this game! " +
                "The guessed word was: " + guessedWord);
        else {
            System.out.println("\nSorry. You have lost this game :( " +
                    "The guessed word was: " + guessedWord);
        }
    }

    // Transform the guessedWord into _____ based on its length
    public StringBuilder getHiddenWord(int length) {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < length; i++) {
            hiddenWord.append("_");
        }

        return hiddenWord;
    }

    public StringBuilder getGuessedLetters(StringBuilder hiddenWord, String word, char letter) {
        StringBuilder result = new StringBuilder(hiddenWord.toString());
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                result.setCharAt(i, letter);
            }
        }

        return result;
    }
}