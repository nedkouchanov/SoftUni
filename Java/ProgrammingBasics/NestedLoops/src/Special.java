import java.util.Scanner;

public class Special {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int start = 1111;
        int finish = 9999;
        boolean flag = false;
        for (int i = start; i <= finish; i++) {
            String nsh = "" + i;
            for (int j = 1; j <= nsh.charAt(i) - 1; j++) {
                i = (int) i;
                if (n % j == 0) {
                    flag = true;
                    continue;
                }
                if (flag) {
                    System.out.println(i + " ");
                }

            }
        }

    }
}

