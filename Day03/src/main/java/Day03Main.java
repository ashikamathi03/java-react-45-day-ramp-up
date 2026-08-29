import java.util.Scanner;
public class Day03Main {
    public static void prime(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("It is a prime number");
        } else {
            System.out.println("It is not a prime number");
        }
    }

    public static void uptoprime(int limit) {

        for (int i = 2; i <= limit; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println("prime numbers: " + i);
            }
        }
    }

    public static void ArmstrongNumber(int n) {
        int temp = n;
        int sum = 0;
        int rem = 0;
        while (temp > 0) {
            rem = temp % 10;
            sum = sum + (rem * rem * rem);
            temp = temp / 10;
        }
        if (sum == n) {
            System.out.println("It is a Armstrong number");
        } else {
            System.out.println("It is not a Armstrong number");
        }
    }

    public static void Fibonacci(int n) {
        int fib1 = 0;
        int fib2 = 1;
        int fib3 = fib1 + fib2;
        for (int i = 0; i <= n; i++) {
            System.out.println(fib1);
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
        }
    }

    public static void DigitSum(int n) {
        int temp = n;
        int sum = 0;
        int rem = 0;
        while (temp > 0) {
            rem = temp % 10;
            sum = sum + rem;
            temp = temp / 10;

        }
        System.out.println(sum);
    }

    public static void Reverse(int n) {
        int temp = n;
        int original = temp;
        int rem = 0;
        int rev = 0;
        while (temp > 0) {
            rem = temp % 10;
            rev = rev * 10 + rem;
            temp = temp / 10;
        }
        System.out.println(rev);
    }

    public static void factors(int n) {
        System.out.println("factors are :");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    public static void table(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + "x" + i + "=" + (n * i));
        }
    }

    public static void main(String[] args) {
        int running = 1;
        while (running == 1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1.1 Prime check   2 Primes upto N   3 Fibonacci   4 Digit sum\n" +
                    "    5 Reverse       6 Factors         7 Armstrong   8 Table    9 Exit");
            System.out.println("Enter the choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Number: ");
                    int num = sc.nextInt();
                    prime(num);
                    break;
                case 2:
                    System.out.println("Enter the Number: ");
                    int number = sc.nextInt();
                    uptoprime(number);
                    break;
                case 3:
                    System.out.println("Enter the Number: ");
                    int fib = sc.nextInt();
                    Fibonacci(fib);
                    break;
                case 4:
                    System.out.println("Enter the number");
                    int digit = sc.nextInt();
                    DigitSum(digit);
                    break;
                case 5:
                    System.out.println("Enter the Number: ");
                    int revnum = sc.nextInt();
                    Reverse(revnum);
                    break;

                case 6:
                    System.out.println("Enter the Number: ");
                    int fact = sc.nextInt();
                    factors(fact);
                    break;
                case 7:
                    System.out.println("Enter the Number: ");
                    int Arm = sc.nextInt();
                    ArmstrongNumber(Arm);
                    break;
                case 8:
                    System.out.println("Enter the Number: ");
                    int tab = sc.nextInt();
                    table(tab);
                    break;
                }
            }

    }

}
