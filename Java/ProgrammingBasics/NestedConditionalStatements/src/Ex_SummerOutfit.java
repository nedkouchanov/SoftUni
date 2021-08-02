import java.util.Scanner;

public class Ex_SummerOutfit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int grad = Integer.parseInt(scan.nextLine());
        String vreme = scan.nextLine();
        String outfit="";
        String shoes="";
        switch (vreme) {
            case "Morning":
                if (grad >= 10 && grad <= 18) {
                    outfit = "Sweatshirt";
                    shoes = "Sneakers";
                    break;
                } else if (grad > 18 && grad <= 24) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                } else if (grad >= 25) {
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                }
            case "Afternoon":
                if (grad >= 10 && grad <= 18) {
                    outfit = "Shirt";
                    shoes = "Moccasins";
                    break;
                } else if (grad > 18 && grad <= 24) {
                    outfit = "T-Shirt";
                    shoes = "Sandals";
                    break;
                } else if (grad >= 25) {
                    outfit = "Swim Suit";
                    shoes = "Barefoot";
                    break;
                }
            case "Evening":
                outfit = "Shirt";
                shoes = "Moccasins";
                break;
        }
        System.out.printf("It's %d degrees, get your %s and %s.", grad, outfit, shoes);
    }
}

