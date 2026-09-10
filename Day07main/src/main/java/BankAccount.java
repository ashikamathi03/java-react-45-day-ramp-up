import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    private static int accountCounter = 1000;
        private static final double MINIMUM_BALANCE = 500.00;
        private final String accountNumber;
        private String holderName;
        private double balance;
        private Transaction[] statementHistory;
        private int transactionCount;
        private static class Transaction {
            private final String timestamp;
            private final String type;
            private final double amount;
            private final double remainingBalance;
            public Transaction(String type, double amount, double remainingBalance) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                this.timestamp = LocalDateTime.now().format(formatter);
                this.type = type;
                this.amount = amount;
                this.remainingBalance = remainingBalance;
            }

            public String getFormattedRecord() {
                String sign = (amount >= 0) ? "+" : "";
                return String.format("%s  %-8s  %s%.2f   %.2f", timestamp, type, sign, amount, remainingBalance);
            }
        }


        public BankAccount(String holderName, double initialDeposit) {
            validateHolderName(holderName);
            validateInitialDeposit(initialDeposit);

            accountCounter++;
            this.accountNumber = "AC-" + accountCounter;
            this.holderName = holderName;
            this.balance = initialDeposit;
            this.statementHistory = new Transaction[100];
            this.transactionCount = 0;

            recordTransaction("OPEN", initialDeposit, this.balance);
        }
        public BankAccount(String holderName) {
            this(holderName, MINIMUM_BALANCE);
        }
        public BankAccount() {
            this("Guest User", MINIMUM_BALANCE);
        }
        private void validateHolderName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Rejected: account holder name cannot be empty");
            }
        }

        private void validateInitialDeposit(double amount) {
            if (amount < MINIMUM_BALANCE) {
                throw new IllegalArgumentException(
                        String.format("Rejected: opening balance below minimum (%.2f)", MINIMUM_BALANCE)
                );
            }
        }


        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Rejected: deposit must be positive");
                return;
            }
            this.balance += amount;
            recordTransaction("DEPOSIT", amount, this.balance);
            System.out.printf("Deposit OK: %s new balance %.2f%n", accountNumber, balance);
        }

        public boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Rejected: withdrawal must be positive");
                return false;
            }

            if (amount > this.balance) {
                System.out.printf("Rejected: insufficient funds (balance %.2f, requested %.2f)%n", this.balance, amount);
                return false;
            }
            this.balance -= amount;
            recordTransaction("WITHDRAW", -amount, this.balance);
            return true;
        }
        void receiveTransfer(double amount) {
            this.balance += amount;
            recordTransaction("TRANSFER", amount, this.balance);
        }

        private void recordTransaction(String type, double amount, double currentBalance) {
            if (transactionCount < statementHistory.length) {
                statementHistory[transactionCount++] = new Transaction(type, amount, currentBalance);
            }
        }
        public void printStatement() {
            System.out.println(accountNumber + " | " + holderName);
            for (int i = 0; i < transactionCount; i++) {
                System.out.println(statementHistory[i].getFormattedRecord());
            }
        }
        public String getAccountNumber() { return accountNumber; }
        public String getHolderName() { return holderName; }
        public double getBalance() { return balance; }
    }

