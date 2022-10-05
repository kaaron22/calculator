import java.util.Scanner;

public class App {
    static final Scanner inputScanner = new Scanner(System.in);

    private static String getString(String prompt) {
        System.out.println(prompt);
        String userString = inputScanner.nextLine();
        return userString;
    }

    private static double getDouble(String prompt) {
        System.out.println(prompt);
        double userDouble = inputScanner.nextDouble();
        return userDouble;
    }

    public static void main(String[] args) {
        
        Boolean goAgain = true;
        while (goAgain) {
            double num1 = getDouble("Please enter first number");
            double num2 = getDouble("Please enter second number");
            
            // System.out.println(String.format("You want to add %.2f and %.2f.", num1, num2));

            Calculator myCalc = new Calculator();
            inputScanner.nextLine();
            String selectedOp = getString("What would you like to do? \n\t add \n\t subtract \n\t multiply \n\t divide \n\t exit");
            while (!selectedOp.equals("add") && !selectedOp.equals("subtract") && !selectedOp.equals("multiply") && !selectedOp.equals("divide") && !selectedOp.equals("exit")) {
                selectedOp = getString("Try again please. What would you like to do? \n\t add \n\t subtract \n\t multiply \n\t divide \n\t exit");
            }

            if (selectedOp.equals("add")) {
                System.out.println(num1 + " + " + num2 + " = " + myCalc.add(num1, num2));
            }
            else if (selectedOp.equals("subtract")) {
                System.out.println(num1 + " - " + num2 + " = " + myCalc.subtract(num1, num2));
            }
            else if (selectedOp.equals("multiply")) {
                System.out.println(num1 + " * " + num2 + " = " + myCalc.multiply(num1, num2));
            }
            else if (selectedOp.equals("divide")) {
                if (num2 == 0) {
                    System.out.println("You cannot divide a number by zero!");
                }
                else {
                    System.out.println(num1 + " / " + num2 + " = " + myCalc.divide(num1, num2));
                }
            }

            String anotherGo = getString("Would you like to perform another calculation (Y/N)? ");
            while (!anotherGo.equals("Y") && !anotherGo.equals("N")) {
                anotherGo = getString("Try again please. Would you like to perform another calculation (Y/N)? ");
            }
            if (anotherGo.equals("N")) {
                System.out.println("Goodbye");
                goAgain = false;
            }
        }
    }
}