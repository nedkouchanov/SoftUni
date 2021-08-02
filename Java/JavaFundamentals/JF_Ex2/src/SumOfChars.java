import java.util.Scanner;

public class SumOfChars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int sum=0;
        for (int i = 1; i <= rows; i++) {
            char symbol = scan.next().charAt(0);
            int value = Character.valueOf(symbol);
            sum += value;
        }
        System.out.printf("The sum equals: %d",sum);
    }
}
