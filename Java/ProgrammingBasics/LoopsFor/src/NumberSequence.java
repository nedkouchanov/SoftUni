import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int maxN = Integer.MIN_VALUE;
        int minN = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number > maxN) {
                maxN = number;
            }
            if (number < minN) {
                minN = number;
            }
        }
        System.out.printf("Max number: %d%n", maxN);
        System.out.printf("Min number: %d", minN);

    }
}
