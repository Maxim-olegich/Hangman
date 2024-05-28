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

        System.out.println("|____________");
        if (userErrorsCounter > 0) {
            System.out.println("|      |");
        } else {
            System.out.println("|      ");
        }

        if (userErrorsCounter > 1) {
            System.out.println("|      0");
        } else {
            System.out.println("|      ");
        }

        if (userErrorsCounter > 4) {
            System.out.println("|     /|\\");
        } else if (userErrorsCounter > 3) {
            System.out.println("|     /|");
        } else if (userErrorsCounter > 2) {
            System.out.println("|      |");
        } else {
            System.out.println("|      ");
        }


        if (userErrorsCounter > 6) {
            System.out.println("|     / \\");
        } else if (userErrorsCounter > 5) {
            System.out.println("|     / ");
        } else {
            System.out.println("|      ");
        }

        System.out.println("|");
    }
}
