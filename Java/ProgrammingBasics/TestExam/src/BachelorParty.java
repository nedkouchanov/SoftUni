import java.util.Scanner;

public class BachelorParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int singer = Integer.parseInt(scan.nextLine());
        String count = scan.nextLine();
        int income = 0;
        int gosti = 0;
        while (!count.equals("The restaurant is full")) {
            int countInt = Integer.parseInt(count);
            if (countInt >= 5) {
                income += countInt * 70;
                gosti += countInt;
            } else {
                income += countInt * 100;
                gosti += countInt;
            }
            count = scan.nextLine();
        }
        int left = income - singer;
        if (left >= 0) {
            System.out.printf("You have %d guests and %d leva left.", gosti, left);
        } else {
            System.out.printf("You have %d guests and %d leva income, but no singer.", gosti, income);
        }
    }
}
