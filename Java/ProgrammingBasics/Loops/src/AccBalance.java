import java.util.Scanner;

public class AccBalance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int counter = 0;
        double balance = 0.0;
        while (counter < n) {
            double amount = Double.parseDouble(scan.nextLine());
            if (amount < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            balance += amount;
            System.out.printf("Increase: %.2f%n", amount);
            counter++;
        }
        System.out.printf("Total: %.2f", balance);
    }
}