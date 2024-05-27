import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        while (true) {
            System.out.println("To start a new game input 'н', to quit input 'в': ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine().toLowerCase();
            if (line.equals("н")) {
                System.out.println("Okay, let's play!");


                String word = dictionary.getWord().toLowerCase();
//                System.out.println("The word is: " + word);
                System.out.println("Length of the word is: " + word.length());

                TheGame game = new TheGame();
                game.startGame(word);
            } else if (line.equals("в")) {
                System.out.println("So, goodbye!");
                break;
            } else {
                System.out.println("[ERROR] Incorrect input, try again...\n");
            }
        }
    }
}