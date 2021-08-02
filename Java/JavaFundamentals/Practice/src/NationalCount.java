import java.util.Scanner;

public class NationalCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int employee1 = Integer.parseInt(scan.nextLine());
        int employee2 = Integer.parseInt(scan.nextLine());
        int employee3 = Integer.parseInt(scan.nextLine());
        int employeesPerHour = employee1 + employee2 + employee3;
        int pplCount = Integer.parseInt(scan.nextLine());
        int hours = 0;

        if (employee1 >= 0 && employee2 >= 0 && employee3 >= 0) {
            if (employee1 <= 100 && employee2 <= 100 && employee3 <= 100) {
                if (pplCount >= 0 && pplCount <= 10000) {
                    for (int i = 0; i < hours+1; i++) {
                        if (hours % 4 == 0) {
                            hours++;
                        }

                        pplCount = pplCount - employeesPerHour;
                        if (pplCount <= 0) {
                            break;
                        }
                    }
                    hours++;
                }
                System.out.printf("Time needed: %dh.", hours);
            }
        }
    }
}