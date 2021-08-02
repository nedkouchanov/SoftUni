import java.util.Scanner;

public class Ex_RectArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x1 = Double.parseDouble(scan.nextLine());
        double y1 = Double.parseDouble(scan.nextLine());
        double x2 = Double.parseDouble(scan.nextLine());
        double y2 = Double.parseDouble(scan.nextLine());
        double a = Math.abs(y2-y1);
        double b = Math.abs(x1-x2);
        double area = a*b;
        double perimeter = (2*a)+(2*b);
        System.out.printf("%.2f\n%.2f",area,perimeter);
    }
}
