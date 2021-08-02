import java.util.Scanner;

public class Lilly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int age = Integer.parseInt(scan.nextLine());
        double wash = Double.parseDouble(scan.nextLine());
        int toyPrice = Integer.parseInt(scan.nextLine());
        int startMoney = 10;
        int ToyCount = 0;
        int moneyBDay = 0;
        int toyTotal;
        for (int i = 1; i <= age; i++) {
            if (i % 2 == 0) {
                moneyBDay += startMoney;
                moneyBDay--;
                startMoney += 10;
            } else {
                ToyCount++;
            }
        }
        toyTotal = ToyCount * toyPrice;
        double totalMoney = toyTotal + moneyBDay;
        double abs = Math.abs(totalMoney - wash);
        if (totalMoney < wash) {
            System.out.printf("No! %.2f", abs);
        } else {
            System.out.printf("Yes! %.2f", abs);
        }
    }
}
