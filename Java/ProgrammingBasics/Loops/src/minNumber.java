import java.util.Scanner;

public class minNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int counter = 0;
        int min = Integer.MAX_VALUE;
        while (counter < num) {
            int integer = Integer.parseInt(scan.nextLine());
            counter++;
            if (integer < min) {
                min = integer;
            }
        }
        System.out.println(min);
    }
}
