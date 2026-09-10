public class Day07Main {

        public static void main(String[] args) {
            Bank bank = new Bank(10);

            System.out.println("> open  Priya  5000");
            bank.openAccount("Priya", 5000.00);
            System.out.println();

            System.out.println("> open  Arun  200");
            bank.openAccount("Arun", 200.00);
            System.out.println();

            System.out.println("> deposit AC-1001 -50");
            BankAccount ac1001 = bank.findAccount("AC-1001");
            if (ac1001 != null) {
                ac1001.deposit(-50);
            }
            System.out.println();

            System.out.println("> withdraw AC-1001 9000");
            if (ac1001 != null) {
                ac1001.withdraw(9000);
            }
            System.out.println();


            bank.openAccount("Arun", 4000.00);

            System.out.println("> transfer AC-1001 AC-1002 1500");
            bank.transfer("AC-1001", "AC-1002", 1500);
            System.out.println();

            System.out.println("> statement AC-1001");
            if (ac1001 != null) {
                ac1001.printStatement();
            }
        }
    }

