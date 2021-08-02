import java.util.Scanner;

public class nums1100 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        while (!(num >=1 && num <=100)){
            System.out.println("Invalid number!");
            num = Integer.parseInt(scan.nextLine());
        }
        System.out.printf("The number is: %d", num);
    }
}
