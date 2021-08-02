import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        matrix(input);
    }

    private static void matrix(int input) {
        for (int i = 0; i < input; i++) {
            int count = input;
            while (count > 0) {
                System.out.print(input + " ");
                count--;
            }
            System.out.println();
        }
    }
}
