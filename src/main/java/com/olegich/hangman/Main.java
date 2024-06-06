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
                String guessableWord = dictionary.getRandomWord().toLowerCase();
//                System.out.println("The guessableWord is: " + guessableWord);
                System.out.println("The length of the guessed word is: " + guessableWord.length());
                Game game = new Game();
                game.start(guessableWord);
            } else if (line.equals("в")) {
                System.out.println("So, goodbye!");
                break;
            } else {
                System.out.println("[ERROR] Incorrect input. Please try again...\n");
            }
        }
    }
}