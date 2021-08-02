import java.util.Scanner;

public class DivideWithout {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double c2 = 0;
        double c3 = 0;
        double c4 = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number % 2 == 0) {
                c2++;
            }
            if (number % 3 == 0) {
                c3++;
            }
            if (number % 4 == 0) {
                c4++;
            }
        }
        System.out.printf("%.2f", (c2 / n) * 100);
        System.out.print("%\n");
        System.out.printf("%.2f", (c3 / n) * 100);
        System.out.print("%\n");
        System.out.printf("%.2f", (c4 / n) * 100);
        System.out.print("%\n");
    }
}
