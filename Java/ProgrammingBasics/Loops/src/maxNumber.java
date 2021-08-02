import java.util.Scanner;

public class maxNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int counter = 0;
        int max = Integer.MIN_VALUE;
        while (counter < num) {
            int integer = Integer.parseInt(scan.nextLine());
            counter++;
            if (integer > max) {
                max = integer;
            }
        }
        System.out.println(max);
    }
}
