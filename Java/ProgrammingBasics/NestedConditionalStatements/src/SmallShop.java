import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String prod = scan.nextLine();
        String town = scan.nextLine();
        double kol = Double.parseDouble(scan.nextLine());
        switch (prod) {
            case "coffee":
                switch (town) {
                    case "Sofia":
                        System.out.println(kol * 0.5);
                        break;
                    case "Plovdiv":
                        System.out.println(kol * 0.4);
                        break;
                    case "Varna":
                        System.out.println(kol * 0.45);
                        break;

                }
        }
        switch (prod) {
            case "water":
                switch (town) {
                    case "Sofia":
                        System.out.println(kol * 0.8);
                        break;
                    case "Plovdiv":
                    case "Varna":
                        System.out.println(kol * 0.7);
                        break;
                }
        }
        switch (prod) {
            case "beer":
                switch (town) {
                    case "Sofia":
                        System.out.println(kol * 1.2);
                        break;
                    case "Varna":
                        System.out.println(kol * 1.1);
                        break;
                    case "Plovdiv":
                        System.out.println(kol * 1.15);
                        break;
                }
        }
        switch (prod) {
            case "sweets":
                switch (town) {
                    case "Sofia":
                        System.out.println(kol * 1.45);
                        break;
                    case "Plovdiv":
                        System.out.println(kol * 1.3);
                        break;
                    case "Varna":
                        System.out.println(kol * 1.35);
                        break;
                }
        }
        switch (prod) {
            case "peanuts":
                switch (town) {
                    case "Sofia":
                        System.out.println(kol * 1.6);
                        break;
                    case "Plovdiv":
                        System.out.println(kol * 1.5);
                        break;
                    case "Varna":
                        System.out.println(kol * 1.55);
                        break;
                }
        }

    }
}

