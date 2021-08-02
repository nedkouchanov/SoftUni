import java.util.Scanner;

public class Ex_DanceHall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double length = Double.parseDouble(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double ward = Double.parseDouble(scan.nextLine());
        double area = length*width;
        double skameika=area/10;
        double areaWard=ward*ward;
        double finalArea = area-(skameika+areaWard);
        int broy = (int)(Math.floor((finalArea/0.704)));

        System.out.println(broy);
    }
}
