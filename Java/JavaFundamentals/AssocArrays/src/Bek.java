import java.util.Scanner;

public class Bek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        int third = Integer.parseInt(scan.nextLine());
        int students = Integer.parseInt(scan.nextLine());
        int studPerHour = first + second + third;
        int hours = 0;
        while (students > 0) {
            students -= studPerHour;
            hours++;
            if (hours % 4 == 0) {
                hours++;
            }
        }
        System.out.println(hours);
    }
}
