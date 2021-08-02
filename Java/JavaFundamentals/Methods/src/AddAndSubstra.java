import java.util.Scanner;

public class AddAndSubstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = Integer.parseInt(scan.nextLine());
        int b = Integer.parseInt(scan.nextLine());
        int c = Integer.parseInt(scan.nextLine());
        addAndSubtrachieren(a,b,c);
    }

    private static void addAndSubtrachieren(int a, int b, int c) {
        int sum = (a+b)-c;
        System.out.println(sum);
    }
}