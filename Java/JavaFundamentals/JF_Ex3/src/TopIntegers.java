import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int[] mas = new int[input.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < mas.length - 1; i++) {
            boolean isTop = true;
            int current = mas[i];
            for (int j = i + 1; j < mas.length; j++) {
                if (current <= mas[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(current + " ");
            }
        }
        System.out.println(mas[mas.length - 1]);
    }
}
