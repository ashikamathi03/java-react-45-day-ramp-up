public class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank(int capacity) {
        this.accounts = new BankAccount[capacity];
        this.count = 0;
    }

    public void openAccount(String holderName, double initialDeposit) {
        try {
            BankAccount account = new BankAccount(holderName, initialDeposit);
            accounts[count++] = account;
            System.out.printf("Account created: %s | %s | balance %.2f%n",
                    account.getAccountNumber(), account.getHolderName(), account.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public void transfer(String fromAccNum, String toAccNum, double amount) {
        BankAccount from = findAccount(fromAccNum);
        BankAccount to = findAccount(toAccNum);

        if (from == null || to == null) {
            System.out.println("Rejected: one or both accounts not found");
            return;
        }

        if (from.withdraw(amount)) {
            to.receiveTransfer(amount);
            System.out.printf("Transfer OK. %s = %.2f, %s = %.2f%n",
                    from.getAccountNumber(), from.getBalance(), to.getAccountNumber(), to.getBalance());
        }
    }

}
