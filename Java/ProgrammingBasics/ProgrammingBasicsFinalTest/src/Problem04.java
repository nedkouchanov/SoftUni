import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String product = scan.nextLine();
        double sum = 0.0;
        int count = 0;
        while (!product.equals("Finish")) {
            double price = 0.0;
            switch (product) {
                case "Star":
                    price = 5.69;
                    count++;
                    break;
                case "Angel":
                    price = 8.49;
                    count++;
                    break;
                case "Lights":
                    price = 11.20;
                    count++;
                    break;
                case "Wreath":
                    price = 15.50;
                    count++;
                    break;
                case "Candle":
                    price = 3.59;
                    count++;
                    break;
            }
            if (count % 3 == 0) {
                price = price * 0.7;
            }
            sum += price;
            if (sum > budget) {
                double need = sum - budget;
                sum -= price;
                count--;
                System.out.printf("Not enough money! You need %.2flv more.%n", need);
                break;
            }
            product = scan.nextLine();
        }
        if (product.equals("Finish")) {
            System.out.print("Congratulations! You bought everything!\n");
        }
        System.out.printf("%d items -> %.2flv spent.", count, sum);
    }
}
