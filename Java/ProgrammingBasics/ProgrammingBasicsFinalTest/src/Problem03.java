import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int power = Integer.parseInt(scan.nextLine());
        String town = scan.nextLine();
        String eco = scan.nextLine();
        double price = 0.0;
        switch (town) {
            case "Sofia":
                if (power <= 37) {
                    price = power * 1.43;
                } else if (power >= 38 && power <= 55) {
                    price = power * 1.5;
                } else if (power > 55) {
                    price = power * 2.68;
                }
                break;
            case "Vidin":
                if (power <= 37) {
                    price = power * 1.34;
                } else if (power >= 38 && power <= 55) {
                    price = power * 1.4;
                } else if (power > 55) {
                    price = power * 2.54;
                }
                break;
            case "Varna":
                if (power <= 37) {
                    price = power * 1.37;
                } else if (power >= 38 && power <= 55) {
                    price = power * 1.4;
                } else if (power > 55) {
                    price = power * 2.57;
                }
                break;
        }
        double totalPrice = 0.0;
        if (eco.equals("Euro 4")) {
            totalPrice = price * .85;
        } else if (eco.equals("Euro 5")) {
            totalPrice = price * 0.83;
        } else if (eco.equals("Euro 6")) {
            totalPrice = price * 0.80;
        }
        System.out.printf("%.2f lv",totalPrice);
    }
}