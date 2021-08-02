import java.util.Scanner;

public class Biscuits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int biscPerWorker = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());
        int biscOtherComapny = Integer.parseInt(scan.nextLine());
        int days = 30;
        double totalBisc = 0;
        for (int i = 1; i <= days; i++) {
            double biscOneDay = biscPerWorker * workers;
            if (i % 3 == 0) {
                biscOneDay = Math.floor(biscOneDay * 0.75);
            }
            totalBisc += biscOneDay;
        }
        System.out.printf("You have produced %.0f biscuits for the past month.%n", totalBisc);
        double diff = Math.abs(totalBisc - biscOtherComapny);
        if (totalBisc > biscOtherComapny) {
            double percentage = (diff / biscOtherComapny) * 100;
            System.out.printf("You produce %.2f percent more biscuits.%n", percentage);
        } else if (totalBisc < biscOtherComapny) {
            double percentage = (diff / biscOtherComapny) * 100;
            System.out.printf("You produce %.2f percent less biscuits.", percentage);
        }
    }
}
