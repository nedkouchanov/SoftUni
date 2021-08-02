import java.util.Scanner;

public class CircleAreaPerimeter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double radius = Double.parseDouble(scan.nextLine());
        double perimeter = 2 * radius * Math.PI;
        double area = Math.PI * Math.pow(radius, 2);
        System.out.printf("%.2f\n", area);
        System.out.printf("%.2f", perimeter);

    }
}
