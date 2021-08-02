import java.util.Scanner;

public class Ex_RadToGrad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double rad = Double.parseDouble(scan.nextLine());
        double grad = rad * 180 / Math.PI;
        System.out.printf("%.0f", grad);
    }
}
