import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        for (int i = input.length() - 1; i >= 0; i--) {
            char currentDig = input.charAt(i);
            int currentDigtoNum = Integer.parseInt("" + currentDig);
            if (currentDigtoNum == 0) {
                System.out.println("ZERO");
                continue;
            }
            for (int n = 1; n <= currentDigtoNum; n++) {
                System.out.print((char) (currentDigtoNum + 33));
            }
            System.out.println();
        }
    }
}
