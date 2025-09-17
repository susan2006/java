import java.io.*;

public class FileEx9 {
    public static void main(String[] args) {
        // Text to write (includes some special characters to test encoding)
        String textToWrite = "Hello, world! Привет мир! ¡Hola mundo! こんにちは世界！";

        // Specify encoding (change to "ISO-8859-1" or others to test)
        String encoding = "UTF-8";

        // Write the text to file using specified encoding
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("example_encoding.txt"), encoding));
            writer.write(textToWrite);
            System.out.println("Text successfully written with encoding: " + encoding);
            writer.flush();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Read the text back using the same encoding
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("example_encoding.txt"), encoding));
            String line;
            System.out.println("Reading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.err.println("Error :" + e.getMessage());

        }
    }
}
