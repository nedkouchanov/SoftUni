import java.util.Scanner;

public class Ex_hotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String month = scan.nextLine();
        int nosht = Integer.parseInt(scan.nextLine());
        double studio = 0;
        double apartment = 0;
        double disc = 1;
        double disca = 1;
        switch (month) {
            case "May":
            case "October":
                if (nosht > 7 && nosht <= 14) {
                    disc = 0.95;
                } else if (nosht > 14) {
                    disc = 0.7;
                    disca = 0.9;
                }
                studio = 50 * disc;
                apartment = 65 * disca;
                break;
            case "June":
            case "September":
                if (nosht > 14) {
                    disc = 0.8;
                    disca = 0.9;
                }
                studio = 75.20 * disc;
                apartment = 68.70 * disca;
                break;
            case "July":
            case "August":
                if (nosht > 14) {
                    disca = 0.9;
                }
                studio = 76;
                apartment = 77 * disca;
                break;
        }
        double finalA = apartment * nosht;
        double finalS = studio * nosht;
        System.out.printf("Apartment: %.2f lv.\n", finalA);
        System.out.printf("Studio: %.2f lv.\n", finalS);

    }
}
