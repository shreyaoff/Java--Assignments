import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = scanner.nextInt();

        if (num / 2 == 0){
            System.out.println(num + " is an even number!");
        }
        else{
            System.out.println(num + " is an odd number!");
        }

        scanner.close();
    }
}
