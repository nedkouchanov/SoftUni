import java.util.Scanner;

//90/100..
public class Traveling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destination = scan.nextLine();
        while (!"End".equalsIgnoreCase(destination)) {
            double budget = Double.parseDouble(scan.nextLine());
            double currentMoney = 0.0;
            while (currentMoney < budget) {
                double collect = Double.parseDouble(scan.nextLine());
                currentMoney += collect;
            }
            System.out.printf("Going to %s!%n", destination);
            destination = scan.nextLine();
        }
    }
}



