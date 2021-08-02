import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            if (number > max) {
                max = number;
            }
            sum += number;
        }
        sum -= max;
        if (sum == max) {
            System.out.printf("Yes%nSum = %d", sum);
        } else {
            int diff = Math.abs(sum - max);
            System.out.printf("No%nDiff = %d", diff);
        }

    }
}
