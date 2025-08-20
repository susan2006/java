class CheckArgument extends Exception
{
    public CheckArgument(String s)
    {
        super(s);
    }
}
public class Argument
{
    public static void main(String[] args) {
        try
        {
        if(args.length<5)
        {
            throw new CheckArgument("Error:Less than 5 arguments.");
        }
        int sum=0;
        for(int i=0;i<5;i++)
        {
            sum+=Integer.parseInt(args[i]);
        }
        System.out.println("Sum:"+sum);
        }
        catch(CheckArgument e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Error:All arguments must be integer");
        }
    }
}