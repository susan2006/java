import java.io.*;
import java.util.Scanner;

public class FileEx11 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the path name: ");
        String pathName = s.nextLine();

        File f = new File(pathName);
        //File f1 = new File("hello");
        //f1.mkdir();

        System.out.println(f.exists()?"File exists.":"File does not exists.");

        System.out.println(f.isFile()?"It is a file.":"It is not a file.");
        System.out.println(f.isDirectory()?"It is a directory.":"It is not a directory.");
        System.out.println(f.canRead()?"File can be read.":"File cannot be read.");
        System.out.println(f.canWrite()?"File can be written.":"File cannot be written");
    }
}
