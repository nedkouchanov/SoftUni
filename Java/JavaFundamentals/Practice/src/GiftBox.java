import java.util.Scanner;

public class GiftBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sheetsCover = 0;
        double sideSize = Double.parseDouble(scan.nextLine());
        double giftBoxArea = Math.pow(sideSize, 2) * 6;
        int sheetsPaper = Integer.parseInt(scan.nextLine());
        double areaSheet = Double.parseDouble(scan.nextLine());
        for (int i = 1; i <= sheetsPaper; i++) {
            double boxFormat = areaSheet;
            if (i % 3 == 0) {
                boxFormat = areaSheet * 0.25;
            }
            sheetsCover += boxFormat;
        }
        double percent = (sheetsCover / giftBoxArea) * 100;
        System.out.printf("You can cover %.2f%% of the box.", percent);
    }
}
