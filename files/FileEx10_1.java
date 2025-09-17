import java.io.File;

public class FileEx10_1 {
    public static void main(String[] args) {
        // Specify the path to the file to delete
        String filePath = "C:\\Users\\student\\Desktop\\Java\\Files\\data.txt";  // Make sure this matches where you created it
        File file = new File(filePath);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully: " + file.getAbsolutePath());
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}
