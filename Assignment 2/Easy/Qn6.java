import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        int num1;
        int num2;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        if(num1 >  num2){
            System.out.println(num1 + " is greater than " + num2);
        }
        else{
            System.out.println(num2 + " is greater than " + num1);
        }
    }
}
