import java.util.Scanner;

public class Ex_UsdBgn {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double usd = Double.parseDouble(scan.nextLine());
        double bgn = usd * 1.79549;
        System.out.printf("%.2f", bgn);

    }
}
