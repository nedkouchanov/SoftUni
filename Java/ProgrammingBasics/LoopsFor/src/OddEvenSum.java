import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 1; i <= n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (i % 2 == 0) {
                evenSum += number;
            } else {
                oddSum += number;
            }
        }
        if (oddSum == evenSum) {
            System.out.printf("Yes%n Sum = %d%n", oddSum);
        } else {
            int diff = Math.abs(oddSum - evenSum);
            System.out.printf("No%n Diff = %d", diff);
        }

    }
}
