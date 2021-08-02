import java.util.Scanner;

public class MultiplyTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        int first = input % 10;
        int third = input / 100;
        int second = input / 10 - (third*10) ;
        for (int i = 0; i <= first; i++) {
            for (int j = 0; j <= second; j++) {
                for (int k = 0; k <= third; k++) {
                    int result = i * j * k;
                    if (i == 0 || j == 0 || k == 0) {
                        continue;
                    }
                    System.out.printf("%d * %d * %d = %d;%n", i, j, k, result);

                }

            }

        }
    }
}

