import java.util.Scanner;

public class EqualSumOddEven {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        for (int i = first; i <= second; i++) {
            int oddSum = 0;
            int evenSum = 0;
            String currentNum = "" + i;
            for (int j = 0; j < currentNum.length(); j++) {
                int currentDigit = Integer.parseInt("" + currentNum.charAt(j));
                if (j % 2 == 0) {
                    evenSum += currentDigit;
                } else {
                    oddSum += currentDigit;
                }

            }
            if (oddSum == evenSum) {
                System.out.print(i + " ");
            }
        }
    }
}
