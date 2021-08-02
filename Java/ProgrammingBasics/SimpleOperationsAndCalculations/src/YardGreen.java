import java.util.Scanner;

public class YardGreen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double sqm = Double.parseDouble(scan.nextLine());
        double sqmprice = sqm * 7.61;
        double priceDisc = sqmprice * 0.18;
        double finalPrice = sqmprice - priceDisc;
        System.out.printf("The final price is: %.2f lv.\nThe discount is: %.2f lv.", finalPrice,priceDisc );
    }
}
