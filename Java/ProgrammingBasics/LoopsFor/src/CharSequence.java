import java.util.Scanner;

public class CharSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        for (int i = 0; i <= string.length() - 1; i++) {
            char a = string.charAt(i);
            System.out.println(a);
        }
    }
}
