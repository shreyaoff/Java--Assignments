import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Account Holder Name: ");
        String holderName = input.nextLine();

        System.out.print("Account Number: ");
        int accountNum = input.nextInt();

        System.out.print("Current Balance: ");
        double initialBalance = input.nextDouble();

        BankAccount account = new BankAccount(holderName, accountNum, initialBalance);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println(" Menu ");
            System.out.println("1. deposit     2. withdraw     3. exit");
            System.out.print("Enter your choice: ");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println(account.deposit());
                    break;

                case 2:
                    System.out.println(account.withdraw());
                    break;

                case 3:
                    System.out.println("Exiting...");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}

class BankAccount {
    String holderName;
    int accountNumber;
    double currentBalance;
    Scanner input = new Scanner(System.in);

    public BankAccount(String holderName, int accountNumber, double currentBalance) {
        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    public double deposit() {
        System.out.print("Enter the amount to be deposited: ");
        double depositAmount = input.nextDouble();
        currentBalance += depositAmount;
        return currentBalance;
    }

    public double withdraw() {
        System.out.print("Enter the amount to be withdrawn: ");
        double withdrawAmount = input.nextDouble();
        if (withdrawAmount > currentBalance) {
            System.out.println("Withdraw amount greater than balance!");
        } else {
            currentBalance -= withdrawAmount;
        }
        return currentBalance;
    }
}