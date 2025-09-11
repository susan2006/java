import java.io.*;

public class FileEx7 {
    public static void main(String[] a) {
        int charCount = 0, wordCount = 0, lineCount = 0;
        boolean inWord = false;

        try {
            FileInputStream fis = new FileInputStream("source.txt");
            int ch;

            while ((ch = fis.read()) != -1) {
                char currentChar = (char) ch;
                charCount++;

                if (currentChar == '\n') {
                    lineCount++;
                }

                if (Character.isWhitespace(currentChar)) {
                    inWord = false;
                } else {
                    if (!inWord) {
                        wordCount++;
                        inWord = true;
                    }
                }
            }

            fis.close();

            // If file doesn't end with a newline, count the last line
            if (charCount > 0 && lineCount == 0) {
                lineCount = 1;
            }

            System.out.println("Characters: " + charCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Lines: " + lineCount);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}