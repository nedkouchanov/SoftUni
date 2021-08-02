import java.util.Scanner;

public class SmallestOfThree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int int1 = Integer.parseInt(scan.nextLine());
        int int2 = Integer.parseInt(scan.nextLine());
        int int3 = Integer.parseInt(scan.nextLine());
        whichIsSmallest(int1, int2, int3);
    }

    private static void whichIsSmallest(int int1, int int2, int int3) {
        if (int1 < int2 && int1 < int3) {
            System.out.println(int1);
        } else if (int2 < int1 && int2 < int3) {
            System.out.println(int2);
        } else {
            System.out.println(int3);
        }
    }
}
