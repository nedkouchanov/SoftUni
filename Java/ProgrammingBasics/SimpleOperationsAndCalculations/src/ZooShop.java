import java.util.Scanner;

public class ZooShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dogs = Integer.parseInt(scan.nextLine());
        int others = Integer.parseInt(scan.nextLine());
        double foodDogs = dogs * 2.5;
        int foodOthers = others * 4;
        double sum = foodDogs + foodOthers;
        System.out.printf("%.2f lv.",sum);
    }
}
