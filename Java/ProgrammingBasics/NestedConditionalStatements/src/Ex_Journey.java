import java.util.Scanner;

public class Ex_Journey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();
        String place = "";
        String type = "";
        double finalsum = 0;
        double priceSumm = 0;
        double priceWint = 0;
        if (budget <= 100) {
            place = "Bulgaria";
            priceSumm = budget * 0.3;
            priceWint = budget * 0.7;
        } else if (budget > 100 && budget <= 1000) {
            place = "Balkans";
            priceSumm = budget * 0.4;
            priceWint = budget * 0.8;
        } else if (budget > 1000) {
            place = "Europe";
            priceSumm = budget * 0.9;
            priceWint = budget * 0.9;
        }
        if (place.equals("Europe")) {
            type = "Hotel";
        } else if (season.equals("winter")) {
            type = "Hotel";
        } else if (season.equals("summer")) {
            type = "Camp";
        }


        if (season.equals("summer")) {
            finalsum = priceSumm;
        } else if (season.equals("winter")) {
            finalsum = priceWint;
        }
        System.out.printf("Somewhere in %s\n", place);
        System.out.printf("%s - %.2f", type, finalsum);

    }
}
