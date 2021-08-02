import java.util.Scanner;

public class AsciiPart {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = Integer.parseInt(scan.nextLine());
        int finish = Integer.parseInt(scan.nextLine());
        for (int i = start; i <= finish; i++) {
            char c = (char) i;
            System.out.printf("%c ", c);
        }
    }
}
