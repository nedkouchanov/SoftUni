import java.util.Scanner;

public class SushiTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        String nameRest = scan.nextLine();
        int count = Integer.parseInt(scan.nextLine());
        String yn = scan.nextLine();
        boolean flag = true;
        double price = 0.0;
        switch (nameRest) {
            case "Sushi Zone":
                if (type.equals("sashimi")) {
                    price = count * 4.99;
                } else if (type.equals("maki")) {
                    price = count * 5.29;
                } else if (type.equals("(uramaki")) {
                    price = count * 5.99;
                } else if (type.equals("temaki")) {
                    price = count * 4.29;
                }
                break;
            case "Sushi Time":
                if (type.equals("sashimi")) {
                    price = count * 5.49;
                } else if (type.equals("maki")) {
                    price = count * 4.69;
                } else if (type.equals("(uramaki")) {
                    price = count * 4.49;
                } else if (type.equals("temaki")) {
                    price = count * 5.19;
                }
                break;
            case "Sushi Bar":
                if (type.equals("sashimi")) {
                    price = count * 5.25;
                } else if (type.equals("maki")) {
                    price = count * 5.55;
                } else if (type.equals("(uramaki")) {
                    price = count * 6.25;
                } else if (type.equals("temaki")) {
                    price = count * 4.75;
                }
                break;
            case "Asian Pub":
                if (type.equals("sashimi")) {
                    price = count * 4.50;
                } else if (type.equals("maki")) {
                    price = count * 4.80;
                } else if (type.equals("(uramaki")) {
                    price = count * 5.50;
                } else if (type.equals("temaki")) {
                    price = count * 5.50;
                }
                break;
            default:
                System.out.printf("%s is invalid restaurant!", nameRest);
                flag = false;
                break;
        }
        if (yn.equals("Y")) {
            price = price + price * 0.20;
        }
        price = Math.ceil(price);
        if (flag) {
            System.out.printf("Total price: %.0f lv.", price);
        }
    }
}