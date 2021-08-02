import java.util.Scanner;

public class Water {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int capacity=255;
        int litersIn = 0;
        for (int i = 0; i < n; i++) {
            int liters = Integer.parseInt(scan.nextLine());
            litersIn += liters;
            if(litersIn>capacity){
                System.out.println("Insufficient capacity!");
                litersIn-=liters;

            }
        }
        System.out.println(litersIn);
    }
}
