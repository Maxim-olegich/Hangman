package com.olegich.hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        while (true) {
            System.out.println("To start a new game, input 'н', to quit, input 'в': ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine().toLowerCase();
            if (line.equals("н")) {
                System.out.println("Okay, let's play!");
                String guessedWord = dictionary.getRandomWord().toLowerCase();
//                System.out.println("The guessedWord is: " + guessedWord);
                System.out.println("The length of the guessed word is: " + guessedWord.length());
                Game game = new Game();
                game.start(guessedWord);
            } else if (line.equals("в")) {
                System.out.println("So, goodbye!");
                break;
            } else {
                System.out.println("[ERROR] Incorrect input. Please try again...\n");
            }
        }
    }
}