import java.io.File;

public class FileEx10 {
    public static void main(String[] args) {
        // Specify the directory where the file will be created
        String directoryPath = "C:\\Users\\student\\Desktop\\Java\\Files";  // Change this path as needed
        File directory = new File(directoryPath);

        // Create directory if it does not exist
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create the file object
        File file = new File(directory, "data.txt");

        try {
            // Create the new file
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists at: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
