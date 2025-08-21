import java.util.*;

public class StringEx2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        String str = "String Exercises";

        System.out.println("The given string is: " + str);

        System.out.print("Enter the letter to check: ");
        String letter = s.next();
        System.out.println(!str.contains(letter) ? "The given string does not contain the letter " + letter + "." : "The given string contains the letter " + letter + ".");
    }
}
