import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int salary = Integer.parseInt(scan.nextLine());
        int counter = 0;
        for (int i = 0; i < n; i++) {
            String tab = scan.nextLine();
            if (tab.equals("Facebook")) {
                salary = salary - 150;
            }
            if (tab.equals("Instagram")) {
                salary = salary - 100;
            }
            if (tab.equals("Reddit")) {
                salary = salary - 50;
            }
            if (salary <= 0) {
                System.out.println("You have lost your salary.");
                break;
            } else {
                counter++;
            }
        }
        if (counter == n) {
            System.out.println(salary);
        }
    }
}
