import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        for (int row = 1; row <= input; row++) {
            for (int i = 0; i < row; i++) {
                System.out.print(row + " ");
            }
            System.out.println();

        }
    }
}
