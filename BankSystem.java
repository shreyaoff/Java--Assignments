// Question 2: Bank Account Simulation
// Create a class BankAccount with private fields accountNumber, balance and methods
// deposit(), withdraw(), and getBalance().
// Create a subclass SavingsAccount with interestRate, override withdraw() to prevent
// balance from dropping below 1000, and add addInterest() method.
// Make all fields private and use getters/setters.

class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MIN_BALANCE = 1000;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < MIN_BALANCE) {
            System.out.println("Withdrawal denied! Balance cannot fall below " + MIN_BALANCE);
        } else {
            super.withdraw(amount);
        }
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        setBalance(getBalance() + interest);
        System.out.println("Interest added: " + interest + " | New Balance: " + getBalance());
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount("SAV-001", 5000, 5);

        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Opening Balance: " + account.getBalance());

        account.deposit(2000);
        account.addInterest();
        account.withdraw(500);
        account.withdraw(6800);
    }
}
