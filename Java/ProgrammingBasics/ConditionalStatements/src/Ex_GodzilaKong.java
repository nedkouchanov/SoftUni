import java.util.Scanner;

public class Ex_GodzilaKong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double budget = Double.parseDouble(scan.nextLine());
        int numSt = Integer.parseInt(scan.nextLine());
        double priceCloth1 = Double.parseDouble(scan.nextLine());
        double dekor = budget * 0.1;
        double pricedrehi = numSt * priceCloth1;
        if (numSt > 150) {
            pricedrehi = pricedrehi * 0.9;
        }
        double cherta = dekor + pricedrehi;

        if (budget < cherta) {
            double need = cherta - budget;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", need);
        } else {
            double izlish = budget - cherta;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", izlish);
        }
    }
}
