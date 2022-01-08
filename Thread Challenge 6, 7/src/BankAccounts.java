import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccounts {

    private double balance;
    private String accountNumber;
    private Lock reentrantLock;

    public BankAccounts(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        reentrantLock = new ReentrantLock();
    }

    public void deposit(double amount) {
        boolean status = false;

        try {
            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println("Couldn't get the lock");
            }
            balance += amount;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (reentrantLock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                System.out.println("Couldn't get the lock");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Transaction status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }

    public double getBalance() {
        return balance;
    }
}