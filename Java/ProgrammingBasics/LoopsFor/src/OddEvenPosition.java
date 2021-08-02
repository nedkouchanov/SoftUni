import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double oddSum = 0;
        double evenSum = 0;
        double oddmax = -2000000000;
        double oddmin = Double.MAX_VALUE;
        double evenmin = Double.MAX_VALUE;
        double evenmax = -2000000000;
        for (int i = 1; i <= n; i++) {
            double number = Double.parseDouble(scan.nextLine());
            if (i % 2 == 0) {
                evenSum = evenSum + number;
                if (number > evenmax) {
                    evenmax = number;
                }
                if (number < evenmin) {
                    evenmin = number;
                }
            } else {
                oddSum = oddSum + number;

                if (number > oddmax) {
                    oddmax = number;
                }
                if (number < oddmin) {
                    oddmin = number;
                }
            }

        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddSum != 0) {
            System.out.printf("OddMin=%.2f,%n", oddmin);
            System.out.printf("OddMax=%.2f,%n", oddmax);
        } else {
            System.out.print("OddMin=No,\n");
            System.out.print("OddMax=No,\n");
        }
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenSum != 0) {
            System.out.printf("EvenMin=%.2f,%n", evenmin);
            System.out.printf("EvenMax=%.2f", evenmax);
        } else {
            System.out.print("EvenMin=No,\n");
            System.out.print("EvenMax=No");
        }
    }
}
