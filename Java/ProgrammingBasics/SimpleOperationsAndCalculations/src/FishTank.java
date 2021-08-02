import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        double percent = Double.parseDouble(scan.nextLine());
        int vol = length*width*height;
        double lvol = vol * 0.001;
        double lfinal = lvol*(1-(percent*0.01));
        System.out.printf("%.3f", lfinal);


    }
}
