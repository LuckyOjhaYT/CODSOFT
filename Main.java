import java.util.Scanner;

class BankAccount {

    private double balance;

    BankAccount(double initialBalance) {
        if (initialBalance > 0)
            this.balance = initialBalance;
        else
            balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Deposite amount must greater then zero.");
            return false;
        }

        balance = getBalance() + amount;
        return true;

    }

    public boolean withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;

        } else if (amount > balance) {
            System.out.println("Insufficient balance");
            return false;

        } else {
            System.out.println("Invalid amount. Withdrawal amount must be greater then zero.");
            return false;
        }

    }

}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        System.out.println("WELCOME to the ATM!");

        while (!exit) {

            System.out.println("\nPlease choose an option");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");

            int choice;

            if (sc.hasNextInt())
                choice = sc.nextInt();
            else {
                System.out.println("Invalid input. Please enter a number from the menu");
                sc.next();
                continue;
            }

            switch (choice) {

                case 1: // Withdraw

                    System.out.print("Enter amount to withdraw: ");
                    if (sc.hasNextDouble()) {

                        double amount = sc.nextDouble();
                        if (account.withdraw(amount))
                            System.out.println("Transaction successful. Please collect your cash: ₹" + amount);
                        else
                            System.out.println("Transaction failed.");

                    } else {
                        System.out.println("Invalid amount entered.");
                        sc.next();
                    }
                    break;

                case 2: // Deposit

                    System.out.print("Enter amount to deposit: ");
                    if (sc.hasNextDouble()) {
                        double amount = sc.nextDouble();

                        if (account.deposit(amount))
                            System.out.println("Deposit successful. ₹" + amount + " has been added to your account.");
                        else
                            System.out.println("Deposite failed");

                    } else {
                        System.out.println("Invalid amount entered.");
                        sc.next();
                    }
                    break;

                case 3: // Check balance
                    System.out.println("Your current balance is: ₹" + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thanks for using the ATM. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter from given choice (1-4)");
            }

        }

        sc.close();

    }
}

public class Main {
    public static void main(String args[]) {

        BankAccount myAccount = new BankAccount(1000);

        ATM myATM = new ATM(myAccount);

        myATM.start();

    }
}