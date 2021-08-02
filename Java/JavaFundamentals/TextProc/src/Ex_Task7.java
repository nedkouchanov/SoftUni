import java.util.Scanner;

public class Ex_Task7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int power = 0;
        StringBuilder resut = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '>') {
                resut.append('>');
                power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            } else if (power == 0) {
                resut.append(symbol);
            } else {
                power--;
            }
        }
        System.out.println(resut);
    }
}
