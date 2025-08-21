import java.util.*;

public class StringEx4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = s.nextLine();

        int uppercase = 0, lowercase = 0;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c >= 'A' && c <= 'Z'){
                uppercase += 1;
            }
            else{
                lowercase += 1;
            }
        }
        System.out.println("Uppercase letters: " + uppercase);
        System.out.println("Lowercase letters: " + lowercase);
        s.close();
    }
}
