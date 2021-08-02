import java.util.Scanner;

public class Ex_OpBetweenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        double result = 0;
        String chetne = "";
        String dey = scan.nextLine();
        if (dey.equals("+")) {
            result = first + second;
            if (result % 2 == 0) {
                chetne = "even";
            } else {
                chetne = "odd";
            }
            System.out.printf("%d %s %d = %d - %s", first, dey, second, (int) result, chetne);
        } else if (dey.equals("-")) {
            result = first - second;
            if (result % 2 == 0) {
                chetne = "even";
            } else {
                chetne = "odd";
            }
            System.out.printf("%d %s %d = %d - %s", first, dey, second, (int) result, chetne);
        } else if (dey.equals("*")) {
            result = first * second;
            if (result % 2 == 0) {
                chetne = "even";
            } else {
                chetne = "odd";
            }
            System.out.printf("%d %s %d = %d - %s", first, dey, second, (int) result, chetne);
        } else if (dey.equals("/")) {
            if (second == 0) {
                System.out.printf("Cannot divide %d by zero", first);
            } else {
                result = first / (double)second;
                System.out.printf("%d %s %d = %.2f", first, dey, second, result);
            }
        } else if (dey.equals("%")) {
            if (second == 0) {
                System.out.printf("Cannot divide %d by zero", first);
            } else {
                result = first % (double)second;
                System.out.printf("%d %s %d = %d", first, dey, second, (int) result);
            }
        }
    }
}
