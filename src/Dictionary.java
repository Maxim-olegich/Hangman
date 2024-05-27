import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {
    private int fileLines;
    private File nouns = new File("nouns.txt");

    public Dictionary() {
        this.fileLines = countLines();
    }

    public String getWord() {
        int randomInt = (int)(Math.random() * fileLines);
        String word = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(nouns))) {
            for (int i = 0; i < randomInt; i++) {
                word = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("[ERROR] Couldn't read nouns.txt in getWord() method.");
            e.printStackTrace();
        }

        return word;
    }

    private int countLines() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(nouns))){
            while (reader.readLine() != null) {
                count++;
            }
        } catch (IOException e) {
            System.out.println("[ERROR] Couldn't read nouns.txt in countLines() method.");
            e.printStackTrace();
        }
        return count;
    }
}
