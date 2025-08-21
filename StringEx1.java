import java.util.*;

public class StringEx1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //assigning using the + operator
        String s1 = "Hello ";
        String s2 = "world!";

        String s3 = s1 + s2;
        System.out.println(s3);

        //using concat method
        String s4 = s3.concat(" This is java programming.");
        System.out.println(s4);

        scanner.close();
    }
}
