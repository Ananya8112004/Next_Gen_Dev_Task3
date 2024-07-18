import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }
    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Your money has been successfully deposited in your account.");
        } else {
            System.out.println("Invalid deposit amount. Please deposit a valid amount.");
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
            System.out.println("Please collect your money from the machine.");
            return true;
        } else {
            System.out.println("Insufficient balance or Invalid amount.");
            return false;
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }
}

public class ATMinterface {
    private static Scanner sc = new Scanner(System.in);
    private static BankAccount account = new BankAccount(50000);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to ATM Interface. How I can Help you!");
            System.out.println("Choose the operation you want to perform from below choice: ");
            System.out.println("Choose 1 for Withdrawing the money.");
            System.out.println("Choose 2 for Depositing the money.");
            System.out.println("Choose 3 for Checking the balance.");
            System.out.println("Choose 4 for EXIT!!");
            System.out.println("Enter choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleWithdraw() {
        System.out.print("Enter the amount to be withdrawn: ");
        int amount = sc.nextInt();
        account.withdraw(amount);
        System.out.println();
    }

    private static void handleDeposit() {
        System.out.print("Enter the amount to be deposited: ");
        int amount = sc.nextInt();
        account.deposit(amount);
        System.out.println();
    }
}
