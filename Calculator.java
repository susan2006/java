import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        String operator;

        try {
            System.out.print("Enter first number: ");
            num1 = Double.parseDouble(scanner.next());

            System.out.print("Enter operator (+, -, *, /): ");
            operator = scanner.next();

            System.out.print("Enter second number: ");
            num2 = Double.parseDouble(scanner.next());

            switch(operator){
                case "+":
                    System.out.println("Sum: " + (num1 + num2));
                    break;
                case "-":
                    System.out.println("Difference: " + (num1 - num2));
                    break;
                case "*":
                    System.out.println("Product: " + (num1 * num2));
                    break;
                case "/":
                    if(num2 == 0){
                        System.out.println("Cannot divide by zero.");
                    }else{
                        System.out.println("Quotient: " + (num1 / num2));
                    }
                    break;
                default:
                    System.out.println("Invalid operator.");
            }
        }
        catch(NumberFormatException e){
            System.out.println("One of the operands is not a number.");
        }
    }
}
