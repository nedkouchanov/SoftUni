package WorkingWithAbstraction.Rectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Point2D leftBottom = new Point2D(coordinates[0], coordinates[1]);
        Point2D topRight = new Point2D(coordinates[2], coordinates[3]);
        Rectangle rectangle = new Rectangle(leftBottom, topRight);
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            coordinates = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Point2D point2D = new Point2D(coordinates[0], coordinates[1]);
            System.out.println(rectangle.contains(point2D));
        }
    }
}
