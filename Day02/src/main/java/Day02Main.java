import java.util.Scanner;

public class Day02Main {
    public static void ConvertTemp(double value, char from, char to) {
        double celsius = 0;
        if (from == 'K' || from == 'k') {
            celsius = (value - 32) * 5 / 9;
        } else if (from == 'F' || from == 'f') {
            celsius = value - 27.15;
        }
        double result = celsius;
        if (to == 'K' || to == 'k') {
            result = (celsius * 9 / 5) + 32;
        } else {
            result = celsius + 273.15;
        }
        System.out.println("Result: " + result);
    }

    public static void ConvertDistance(double value, char from) {
        double result = 0.0;
        if (from == 'M' || from == 'm') {
            result = value * 1.609;
        } else {
            result = value / 1.609;
        }
        System.out.println("Result: " + result);
    }

    public static void CovertWeight(double value, char from) {
        double result = 0.0;
        if (from == 'K' || from == 'k') {
            result = value * 2.205;
        } else {
            result = value / 2.205;
        }
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        System.out.println("Converter");
        System.out.println("1.Temperature ");
        System.out.println("2.Distance ");
        System.out.println("3. weight");
        System.out.println("4.Exit");
        System.out.print("Enter the choice: ");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("From temperature(c/f/k");
                char tempfrom = sc.next().charAt(0);
                System.out.print("To unit (C/F/K): ");
                char tempTo = sc.next().charAt(0);
                System.out.print("Enter value: ");
                double tempVal = sc.nextDouble();

                ConvertTemp(tempVal, tempfrom, tempTo);
                break;
            case 2:
                System.out.print("From unit (M for Miles, K for KM): ");
                char distFrom = sc.next().charAt(0);
                System.out.print("Enter value: ");
                double distVal = sc.nextDouble();

                ConvertDistance(distVal, distFrom);
                break;

            case 3:
                System.out.print("From unit (K for KG, P for Pounds): ");
                char weightFrom = sc.next().charAt(0);
                System.out.print("Enter value: ");
                double weightVal = sc.nextDouble();

                CovertWeight(weightVal, weightFrom);
                break;

            case 4:
                running = false;
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid choice. Try again.");
        }


        sc.close();
    }


}


