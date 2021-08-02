import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double countp1 = 0;
        double countp2 = 0;
        double countp3 = 0;
        double countp4 = 0;
        double countp5 = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number < 200) {
                countp1++;
            } else if (number >= 200 && number < 400) {
                countp2++;
            } else if (number >= 400 && number < 600) {
                countp3++;
            } else if (number >= 600 && number < 800) {
                countp4++;
            } else if (number >= 800) {
                countp5++;
            }
        }
        System.out.printf("%.2f", (countp1 / n) * 100);
        System.out.print("%\n");
        System.out.printf("%.2f", (countp2 / n) * 100);
        System.out.print("%\n");
        System.out.printf("%.2f", (countp3 / n) * 100);
        System.out.print("%\n");
        System.out.printf("%.2f", (countp4 / n) * 100);
        System.out.print("%\n");
        System.out.printf("%.2f", (countp5 / n) * 100);
        System.out.print("%");
    }
}
