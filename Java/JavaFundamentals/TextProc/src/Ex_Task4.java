import java.util.Scanner;

public class Ex_Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char letter = (char) (message.charAt(i) + 3);
            result.append(letter);
        }
        System.out.println(result);
    }
}
