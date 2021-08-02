import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int end = Integer.parseInt(scan.nextLine());
        int number = Integer.parseInt(scan.nextLine());
        int counter = 0;
        boolean found = false;
        for (int x1 = start; x1 <= end; x1++) {
            for (int x2 = start; x2 <= end; x2++) {
                counter++;
                int result = x1 + x2;
                if (number == result) {
                    found = true;
                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, x1, x2, result);
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.printf("%d combinations - neither equals %d", counter, number);
        }
    }
}
