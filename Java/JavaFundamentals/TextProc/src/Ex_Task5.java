import java.util.Scanner;

public class Ex_Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();
        StringBuilder result = new StringBuilder();
        int reminder = 0;
        int multiplier = Integer.parseInt(scan.nextLine());
        if (multiplier == 0) {
            System.out.println(0);
            return;
        }
        while (number.charAt(0) == '0') {
            number = number.substring(1);
        }
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt
                    (String.valueOf(number.charAt(i)));
            int product = digit * multiplier + reminder;
            result.append(product % 10);
            reminder = product / 10;
        }
        if (reminder != 0) {
            result.append(reminder);
        }
        System.out.println(result.reverse());
    }
}
