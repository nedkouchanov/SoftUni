import java.util.Scanner;

public class Problem01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int months = Integer.parseInt(scan.nextLine());
        int comissionPercent = Integer.parseInt(scan.nextLine());
        double priceMonth = Double.parseDouble(scan.nextLine());
        double monthsSecondHalf = Math.ceil((double) months / 2);
        double monthsFirstHalf = months - monthsSecondHalf;
        double firstHalf = monthsFirstHalf * priceMonth;
        double secondHalf = monthsSecondHalf * priceMonth * 0.8;
        double total = firstHalf + secondHalf;
        double forBroker = total * ((double) comissionPercent / 100);
        double totalMoney = total + forBroker;
        System.out.printf("Total: %.2f", totalMoney);
    }

}

