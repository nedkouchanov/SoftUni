import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int[] mas = new int[input.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Integer.parseInt(input[i]);

        }
    }
}
