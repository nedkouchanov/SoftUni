import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String pass = scan.nextLine();
        String input = scan.nextLine();
        while(!pass.equals(input)){
            input=scan.nextLine();
        }
        System.out.printf("Welcome %s!",name);
    }
}
