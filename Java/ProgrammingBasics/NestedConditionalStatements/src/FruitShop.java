import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String veg = scan.nextLine();
        String day = scan.nextLine();
        double kol = Double.parseDouble(scan.nextLine());
        if (veg.equals("banana") || veg.equals("apple") || veg.equals("orange") ||
                veg.equals("grapefruit") || veg.equals("kiwi") || veg.equals("pineapple") || veg.equals("grapes")) {
            if (day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") ||
                    day.equals("Thursday") || day.equals("Friday") || day.equals("Saturday") || day.equals("Sunday")) {
                switch (day) {
                    case "Monday":
                    case "Tuesday":
                    case "Wednesday":
                    case "Thursday":
                    case "Friday":
                        switch (veg) {
                            case "banana":
                                System.out.printf("%.2f", 2.50 * kol);
                                break;
                            case "apple":
                                System.out.printf("%.2f", 1.20 * kol);
                                break;
                            case "orange":
                                System.out.printf("%.2f", 0.85 * kol);
                                break;
                            case "grapefruit":
                                System.out.printf("%.2f", 1.45 * kol);
                                break;
                            case "kiwi":
                                System.out.printf("%.2f", 2.70 * kol);
                                break;
                            case "pineapple":
                                System.out.printf("%.2f", 5.50 * kol);
                                break;
                            case "grapes":
                                System.out.printf("%.2f", 3.85 * kol);
                                break;
                        }
                }
                switch (day) {
                    case "Saturday":
                    case "Sunday":
                        switch (veg) {
                            case "banana":
                                System.out.printf("%.2f", 2.7 * kol);
                                break;
                            case "apple":
                                System.out.printf("%.2f", 1.25 * kol);
                                break;
                            case "orange":
                                System.out.printf("%.2f", 0.90 * kol);
                                break;
                            case "grapefruit":
                                System.out.printf("%.2f", 1.60 * kol);
                                break;
                            case "kiwi":
                                System.out.printf("%.2f", 3.0 * kol);
                                break;
                            case "pineapple":
                                System.out.printf("%.2f", 5.60 * kol);
                                break;
                            case "grapes":
                                System.out.printf("%.2f", 4.20 * kol);
                                break;
                        }
                }
            } else {
                System.out.println("error");
            }
        } else {
            System.out.println("error");
        }
    }
}
