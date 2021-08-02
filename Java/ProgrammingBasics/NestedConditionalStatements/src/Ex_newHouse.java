import java.util.Scanner;

public class Ex_newHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        int num = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());
        double priceRos = 5 * num;
        double priceDah = 3.8 * num;
        double priceTul = 2.8 * num;
        double priceNar = 3 * num;
        double priceGla = 2.5 * num;
        double finals = 0.0;
        switch (type) {
            case "Roses":
                if (num > 80) {
                    finals = priceRos * 0.9;
                    break;
                } else {
                    finals = priceRos;
                    break;
                }
            case "Dahlias":
                if (num > 90) {
                    finals = priceDah * 0.85;
                    break;
                } else {
                    finals = priceDah;
                    break;
                }
            case "Tulips":
                if (num > 80) {
                    finals = priceTul * 0.85;
                    break;
                } else {
                    finals = priceTul;
                    break;
                }
            case "Narcissus":
                if (num < 120) {
                    priceNar=priceNar+(priceNar*0.15);
                    finals = priceNar;
                    break;
                } else {
                    finals = priceNar;
                    break;
                }
            case "Gladiolus":
                if (num < 80) {
                    priceGla=priceGla+(priceGla*0.2);
                    finals = priceGla;
                    break;
                } else {
                    finals = priceGla;
                    break;
                }
        }
        double rest = Math.abs(budget - finals);
        if (budget >= finals) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", num, type, rest);
        } else if (budget < finals) {
            System.out.printf("Not enough money, you need %.2f leva more.", rest);
        }
    }
}
