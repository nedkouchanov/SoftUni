import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        String day = scan.nextLine();
        double priceForEach = 0;
        double totalPrice = 0;
        if (type.equals("Students")) {
            switch (day) {
                case "Friday":
                    priceForEach = 8.45;
                    break;
                case "Saturday":
                    priceForEach = 9.80;
                    break;
                case "Sunday":
                    priceForEach = 10.46;
                    break;
            }
            totalPrice = people * priceForEach;
            if (people >= 30) {
                totalPrice *= 0.85;
            }
        }
        if (type.equals("Business")) {
            switch (day) {
                case "Friday":
                    priceForEach = 10.9;
                    break;
                case "Saturday":
                    priceForEach = 15.6;
                    break;
                case "Sunday":
                    priceForEach = 16;
                    break;
            }
            if (people >= 100) {
                people -= 10;
            }
            totalPrice = people * priceForEach;
        }
        if (type.equals("Regular")) {
            switch (day) {
                case "Friday":
                    priceForEach = 15;
                    break;
                case "Saturday":
                    priceForEach = 20;
                    break;
                case "Sunday":
                    priceForEach = 22.5;
                    break;
            }
            totalPrice = people * priceForEach;
            if (people >= 10 && people <= 20) {
                totalPrice *= 0.95;
            }
        }
        System.out.printf("Total price: %.2f ", totalPrice);
    }
}
