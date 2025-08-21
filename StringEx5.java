import java.util.*;

public class StringEx5 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = s.nextLine();
        char[] charstr1 = str1.toCharArray();

        System.out.print("Enter second string: ");
        String str2 = s.nextLine();
        char[] charstr2 = str2.toCharArray();

        Arrays.sort(charstr1);
        Arrays.sort(charstr2);

        if(!Arrays.equals(charstr1,charstr2)){
            System.out.println("The strings are not anagram.");
        }
        else{
            System.out.println("The strings are anagram.");
        }

    }
}
