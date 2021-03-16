package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------");
        System.out.println("This is your mini calculator!");
        System.out.println("------------------------------------------------");
        do {
            System.out.println("What operation do you wish to perform?");
            System.out.print("1 : Get square root\n2 : Get Factorial\n3 : Get Natural Log\n4 : Get Power\n" +
                    "Enter any other key to exit.");
            int val;
            try {
                val = scanner.nextInt();
            } catch (InputMismatchException error) {
                System.out.println("You have now left...");
                return;
            }

            double n1;
            switch (val) {
                case 1:
                    try {
                        System.out.print("Enter the number : ");
                        n1 = scanner.nextDouble();
                    } catch (InputMismatchException error) {
                        logger.error("Please enter a valid input number.\n");
                        return;
                    }
                    System.out.println("\nSquare root of " + n1 +" is : " + calculator.squareRoot(n1));
                    System.out.println("------------------------------------------------");
                    break;
                case 2:
                    int n2;
                    try {
                        System.out.print("Enter the number : ");
                        n2 = scanner.nextInt();
                    } catch (InputMismatchException error) {
                        logger.error("Please enter a valid input number.\n");
                        return;
                    }
                    System.out.println("\nFactorial of " + n2 + " is: " + calculator.factorial(n2));
                    System.out.println("------------------------------------------------");
                    break;
                case 3:
                    try {
                        System.out.print("Enter the number : ");
                        n1 = scanner.nextDouble();
                    } catch (InputMismatchException error) {
                        logger.error("Please enter a valid input number.\n");
                        return;
                    }
                    System.out.println("\nNatural log of " + n1 +" is : " + calculator.naturalLog(n1));
                    System.out.println("------------------------------------------------");
                    break;
                case 4:
                    double num2;
                    try {
                        System.out.print("Enter the base number : ");
                        n1 = scanner.nextDouble();
                        System.out.print("Enter the power : ");
                        num2 = scanner.nextDouble();
                    } catch (InputMismatchException error) {
                        logger.error("Please enter a valid input number.\n");
                        return;
                    }
                    System.out.println("\n" + n1 + " to the power " + num2 +" is : " + calculator.power(n1, num2));
                    System.out.println("------------------------------------------------");
                    break;
                default:
                    System.out.println("\nYou have now left...");
                    System.out.println("------------------------------------------------");
                    return;
            }
        } while (true);

    }

    public double power(double num, double num2) {
        double result;
        logger.info("Calculating " + num + " to the power " + num2 + "...");
        result = Math.pow(num, num2);
        logger.info("Power operation result : " + result);
        return result;
    }

    public double naturalLog(double num) {
        double result = 0;
        try{
            logger.info("Calculating natural log of " + num + "...");
            if(num <= 0){
                result = Double.NaN;
                throw new ArithmeticException("Error Nan: Log of <= 0 asked!");
            }
            else{
                result = Math.log(num);
            }
        }
        catch(ArithmeticException err){
            logger.error("Error: Log of <= 0 asked! " + err.getMessage());
        }
        finally {
            logger.info("Natural Log result : " + result);
        }
        return result;
    }

    public double factorial(double num) {
        double result = 1;
        try{
            if(num != (int)num){
                result = Double.NaN;
            }

            if(num < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Error Nan: Factorial of < 0 asked!");
            }

            if(num == 0 || num == 1) return 1;

            for(int i = 1; i <= num; i++){
                result *= i;
            }
        }
        catch(ArithmeticException err) {
            logger.error("Error: Factorial of < 0 asked! " + err.getMessage());
        }
        finally {
            logger.info("Factorial result : " + result);
        }

        return result;
    }

    public double squareRoot(double num) {
        double result = 0;
        try{
            logger.info("Calculating Square root  of " + num + "...");
            if(num < 0){
                result = Double.NaN;
                throw new ArithmeticException("Error Nan: SquareRoot of < 0 asked!");
            }
            else{
                result = Math.sqrt(num);
            }
        }catch(ArithmeticException err){
            logger.error("Error: SquareRoot of <= 0 asked! " + err.getMessage());
        }finally {
            logger.info("SquareRoot result : " + result);
        }

        return result;
    }
}