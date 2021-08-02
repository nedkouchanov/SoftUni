import java.util.Scanner;

public class Bus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int depart = Integer.parseInt(scan.nextLine());
        int stops = Integer.parseInt(scan.nextLine());
        int total = depart;
        for (int i = 1; i <= stops; i++) {
            int sliz = Integer.parseInt(scan.nextLine());
            int kach = Integer.parseInt(scan.nextLine());
            if (i % 2 == 0) {
                total -= 2;
            } else {
                total += 2;
            }
            total += kach - sliz;


        }
        System.out.printf("The final number of passengers is : %d", total);

    }
}
