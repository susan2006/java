import java.util.*;
public class Odd
{
    static void checkodd(int n) throws Exception
    {
        if(n%2!=0)
        {
            throw new Exception("Entered umber is odd");
        }
        else
        {
            System.out.println("Number is even");
        }
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number to check:");
        int n=sc.nextInt();
        try 
        {
            checkodd(n);
        } 
        catch (Exception e) 
        {
            System.out.print("Error:"+e.getMessage());
        }        
    }
}