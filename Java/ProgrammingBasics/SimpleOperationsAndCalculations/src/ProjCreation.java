import java.util.Scanner;

public class ProjCreation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int proj = Integer.parseInt(scan.nextLine());
        int hours = proj*3;
        System.out.printf("The architect %s will need %d hours to complete %d project/s.", name, hours,proj);
    }
}
