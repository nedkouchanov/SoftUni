import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = "";
        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }
        for (int i = 1; i <= 4; i++) {
            String input = scan.nextLine();
            if (input.equals(password)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else if (i == 4) {
                System.out.printf("User %s blocked!", username);
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        }
    }
}
