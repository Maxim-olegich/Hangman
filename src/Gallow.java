import org.w3c.dom.ls.LSOutput;

public class Gallow {
    private int count;

    public Gallow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void drawGallow() {
        /*
        |____________
        |      |
        |      0
        |     /|\
        |     / \
        |
         */
        System.out.println("|____________");
        if (count > 0) {
            System.out.println("|      |");
        } else {
            System.out.println("|      ");
        }

        if (count > 1) {
            System.out.println("|      0");
        } else {
            System.out.println("|      ");
        }

        if (count > 4) {
            System.out.println("|     /|\\");
        } else if (count > 3) {
            System.out.println("|     /|");
        } else if (count > 2) {
            System.out.println("|      |");
        } else {
            System.out.println("|      ");
        }


        if (count > 6) {
            System.out.println("|     / \\");
        } else if (count > 5) {
            System.out.println("|     / ");
        } else {
            System.out.println("|      ");
        }

        System.out.println("|");
    }
}
