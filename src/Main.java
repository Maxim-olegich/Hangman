import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("To start a new game input 'n', to quit input 'q': ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.equals("n")) {
                System.out.println("Okay, let's play!");

                Dictionary dictionary = new Dictionary();
                String word = dictionary.getWord().toLowerCase();
                System.out.println("The word is: " + word);
                System.out.println("Length of the word is: " + word.length());

                TheGame game = new TheGame();
                game.startGame(word);
            } else if (line.equals("q")) {
                System.out.println("So, goodbye!");
                break;
            } else {
                System.out.println("[ERROR] Incorrect input, try again...\n");
            }
        }
    }
}