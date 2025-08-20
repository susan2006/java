import java.util.Scanner;

public class ExceptionHandlerEx3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        System.out.print("Enter any index: ");
        int index = s.nextInt();
        try {
            System.out.println(array[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Error: Entered index is out of bounds.");
        }
        s.close();
    }
}
