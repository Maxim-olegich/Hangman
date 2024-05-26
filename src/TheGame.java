import java.util.Scanner;

public class TheGame {
    public void startGame(String word) {
        StringBuilder hiddenWord = getHiddenWord(word.length());
        Gallow gallow = new Gallow(0);
        gallow.drawGallow();
        while (hiddenWord.indexOf("_") != -1) {

            if (gallow.getCount() == 7) break;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Progress: " + hiddenWord.toString() + ". Input a cyrillic letter: ");
            String letter = scanner.nextLine().toLowerCase();

            if (letter.length() > 1 || letter.isBlank()) {
                System.out.println("[ERROR] Please, input only one letter!");
            } else if (letter.charAt(0) >= 'а' && letter.charAt(0) <= 'я') {
                StringBuilder temp = checkLetter(hiddenWord, word, letter.toCharArray()[0]);
                if (temp.compareTo(hiddenWord) == 0) {
                    System.out.println("You didn't guess the letter");
                    gallow.setCount(gallow.getCount() + 1);
                    gallow.drawGallow();
                } else {
                    System.out.println("Yes! You guessed the letter!");
                    hiddenWord = temp;
                }
            } else {
                System.out.println("[ERROR] Input a cyrillic letter, please.");
            }
        }

        if (gallow.getCount() < 7) System.out.println("Congrats! You are won this game!\n" +
                "The word was: " + word);
        else System.out.println("Sorry. You lost this game :(");
    }

    public StringBuilder getHiddenWord(int length) {
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < length; i++) {
            hiddenWord.append("_");
        }
        return hiddenWord;
    }

    public StringBuilder checkLetter(StringBuilder hiddenWord, String word, char letter) {
        StringBuilder result = new StringBuilder(hiddenWord.toString());
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                result.setCharAt(i, letter);
            }
        }
        return result;
    }

}