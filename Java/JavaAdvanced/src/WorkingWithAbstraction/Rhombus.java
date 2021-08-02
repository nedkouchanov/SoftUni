package WorkingWithAbstraction;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        System.out.print(createTopHalf(n) + createBottomHalf(n));
    }

    private static String repeatString(String str, int count) {
        return str.repeat(count);
    }

    public static String createTopHalf(int n) {
        StringBuilder out = new StringBuilder();
        for (int row = 1; row <= n; row++) {
            out.append(repeatChar(' ', n - row));
            out.append(repeatString("* ", row));
            out.append(System.lineSeparator());
        }
        return out.toString();
    }

    public static String createBottomHalf(int n) {
        StringBuilder out = new StringBuilder();
        for (int row = 1; row <= n - 1; row++) {
            out.append(repeatChar(' ', row));
            out.append(repeatString("* ", n - row));
            out.append(System.lineSeparator());
        }
        return out.toString();
    }

    public static String repeatChar(char symbol, int count) {
        return repeatString(String.valueOf(symbol), count);
    }
}
