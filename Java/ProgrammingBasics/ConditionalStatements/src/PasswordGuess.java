import java.util.Scanner;

public class PasswordGuess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pass = scan.nextLine();
        String givenPass = "s3cr3t!P@ssw0rd";
        if (pass.equals(givenPass)){
            System.out.println("Welcome");
        } else {
            System.out.println("Wrong password!");
        }
    }
}
