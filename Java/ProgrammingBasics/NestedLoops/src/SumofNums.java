import java.util.Scanner;

public class SumofNums {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        int sumPrimes = 0;
        int sumNonPrimes = 0;

        while (!string.equals("stop")) {
            int n = Integer.parseInt(string);
            if (n < 0) {
                System.out.println("Number is negative.");
            }
            for (int i = 2; i <= n / 2; ++i) {
                if (n % i == 0) {
                    sumNonPrimes += n;
                } else {
                    sumPrimes += n;
                }
            }
            string = scan.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", sumPrimes);
        System.out.printf("Sum of all non prime numbers is: %d", sumNonPrimes);
    }
}
