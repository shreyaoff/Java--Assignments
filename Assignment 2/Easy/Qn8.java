import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        int num1;
        int num2;
        String operator;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();

        System.out.print("Enter an operator (+, -, *, /): ");
        operator = scanner.next();

        if(operator.equals("+")){
            System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
        }
        else if (operator.equals("-")) {
            System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
        }
        else if (operator.equals("*")) {
            System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
        }
        else if (operator.equals("/")) {
            if(num2!=0){
                System.out.println(num1 + " / " + num2 + " = " + (num1/num2));
            }
            else{
                System.out.println("Number can't be divisible by 0!");
            }
        }
        else{
            System.out.println("Invalid input!");
        }

    }
}
