import java.util.Scanner;

public class Ex_Boat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int budget = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        int num = Integer.parseInt(scan.nextLine());
        double disc = 1;
        double firstDisc = 1;
        double naem = 0;
        if (num <= 6) {
            firstDisc = 0.9;
        } else if (num > 6 && num <= 11) {
            firstDisc = 0.85;
        } else if (num > 11) {
            firstDisc = 0.75;
        }
        if (!season.equals("Autumn")) {
            if (num % 2 == 0) {
                disc = 0.95;
            }
        }
        switch (season) {
            case "Spring":
                naem = 3000;
                break;
            case "Summer":
            case "Autumn":
                naem = 4200;
                break;
            case "Winter":
                naem = 2600;
                break;
        }
        double finalprice = (naem * firstDisc) * disc;
        double needleft = Math.abs(budget - finalprice);
        if (budget >= finalprice) {
            System.out.printf("Yes! You have %.2f leva left.", needleft);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", needleft);
        }
    }
}
