import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileEx5 {
    public static void main(String[] a){
        try{
            FileInputStream fis = new FileInputStream("dog.jpg");
            FileOutputStream fos = new FileOutputStream("dog2.jpg");

            int i;

            while((i = fis.read()) != -1){
                fos.write((byte)i);
            }
            System.out.println("Successfully copied the image.");
            fis.close();
            fos.close();
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
