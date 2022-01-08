public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("1", 1000);
        Thread firstUser = new Thread() {
            @Override
            public void run() {
                    System.out.println(bankAccount.getBalance());
                    bankAccount.deposit(300);
                    System.out.println(bankAccount.getBalance());
                    bankAccount.withdraw(50);
                    System.out.println(bankAccount.getBalance());
            }
        };

        Thread secondUser = new Thread() {
            @Override
            public void run() {
                    System.out.println(bankAccount.getBalance());
                    bankAccount.deposit(203.75);
                    System.out.println(bankAccount.getBalance());
                    bankAccount.withdraw(100.00);
                    System.out.println(bankAccount.getBalance());
            }
        };
        firstUser.start();
        secondUser.start();
    }
}
