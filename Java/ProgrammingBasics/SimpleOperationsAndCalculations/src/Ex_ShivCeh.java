import java.util.Scanner;

public class Ex_ShivCeh {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        double len = Double.parseDouble(scan.nextLine());
        double wid = Double.parseDouble(scan.nextLine());
        double areapokr = (len+0.3*2)*(wid+0.3*2);
        double areakare = Math.pow((len/2),2);
        double usdpokr = areapokr * 7 * num;
        double usdkare = areakare * 9 * num;
        double bgnpokr = usdpokr * 1.85;
        double bgnkare = usdkare * 1.85;
        double usd = usdkare+usdpokr;
        double bgn = bgnkare+bgnpokr;
        System.out.printf("%.2f USD\n%.2f BGN", usd, bgn);

    }
}
