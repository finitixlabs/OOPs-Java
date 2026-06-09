import java.util.Scanner;

/*
 * =====================================================
 *              BANK MANAGEMENT SYSTEM
 * =====================================================
 * Concepts Covered:
 * 1. Encapsulation
 * 2. Inheritance
 * 3. Polymorphism
 * 4. Abstraction
 * 5. Constructors
 * 6. User Input (Scanner)
 * 7. Menu Driven Program
 * =====================================================
 */

/**
 * Abstract parent class representing a generic bank account.
 * Demonstrates Abstraction and Encapsulation.
 */
abstract class Account {

    // Common account information available to child classes
    protected String accountHolder;
    protected double balance;

    /**
     * Constructor used to initialize account details.
     *
     * @param accountHolder Name of account holder
     * @param balance Initial account balance
     */
    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    /**
     * Deposits money into account.
     *
     * @param amount Amount to deposit
     */
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    /**
     * Abstract method.
     * Each account type will have its own withdrawal rule.
     */
    public abstract void withdraw(double amount);

    /**
     * Displays account details.
     */
    public void checkBalance() {
        System.out.println("\n----- ACCOUNT DETAILS -----");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Current Balance: ₹" + balance);
    }
}

/**
 * Savings Account implementation.
 * Demonstrates Inheritance and Method Overriding.
 */
class SavingsAccount extends Account {

    /**
     * Constructor
     */
    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    /**
     * Savings account allows withdrawal only
     * if sufficient balance is available.
     */
    @Override
    public void withdraw(double amount) {

        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

/**
 * Current Account implementation.
 * Allows overdraft facility.
 */
class CurrentAccount extends Account {

    // Maximum overdraft allowed
    private final double OVERDRAFT_LIMIT = 5000;

    /**
     * Constructor
     */
    public CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    /**
     * Current account withdrawal logic.
     * User can withdraw beyond available balance
     * up to overdraft limit.
     */
    @Override
    public void withdraw(double amount) {

        if (amount <= balance + OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}

/**
 * Driver class.
 * Application starts from here.
 */
public class Bank_Management_System {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     BANK MANAGEMENT SYSTEM");
        System.out.println("=================================");

        // Collect account holder information
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        // Select account type
        System.out.println("\nSelect Account Type");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");

        System.out.print("Enter Choice: ");
        int accountType = sc.nextInt();

        /*
         * Polymorphism:
         * Parent reference storing child object.
         */
        Account account;

        if (accountType == 1) {
            account = new SavingsAccount(name, balance);
        } else {
            account = new CurrentAccount(name, balance);
        }

        // Main application menu
        while (true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("==========================");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ₹");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ₹");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("\nThank you for using our banking system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}