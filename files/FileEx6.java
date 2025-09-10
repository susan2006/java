import java.io.*;

public class FileEx6 {
    public static void main(String[] a){
        try{
            FileInputStream fis = new FileInputStream("mydata.txt");
            FileOutputStream fos = new FileOutputStream("mydataupper.txt");

            int i;
            while((i  = fis.read()) != -1){
                char c = (char)i;
                char ab = Character.toUpperCase(c);
                fos.write((byte)ab);
            }
            System.out.println("Successfully written the text to another file in upper case.");
            fis.close();
            fos.close();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
