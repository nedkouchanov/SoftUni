import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int num = Integer.parseInt(input);
        printSign(num);
    }

    private static void printSign(int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.", number);
    } else if (number < 0){
            System.out.printf("The number %d is negative.", number);
        } else {
            System.out.printf("The number %d is zero.", number);
        }
    }
}