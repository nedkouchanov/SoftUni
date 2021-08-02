import java.util.Scanner;

public class Ex_Alcohol {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        double wiskeyLv = Double.parseDouble(scan.nextLine());
        double biraL = Double.parseDouble(scan.nextLine());
        double vinoL = Double.parseDouble(scan.nextLine());
        double rakiaL = Double.parseDouble(scan.nextLine());
        double wiskeyL = Double.parseDouble(scan.nextLine());
        double rakiaLv = wiskeyLv / 2;
        double vinoLv = rakiaLv-(rakiaLv / 2.5);
        double biraLv = rakiaLv-(rakiaLv / 1.25);
        double total = (wiskeyL*wiskeyLv) + (biraL*biraLv) + (rakiaL*rakiaLv) + (vinoL*vinoLv);
        System.out.printf("%.2f",total );

    }
}
