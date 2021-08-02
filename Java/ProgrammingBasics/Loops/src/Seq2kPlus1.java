import java.util.Scanner;

public class Seq2kPlus1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        int counter = 1;
        while (counter <= num) {
            System.out.println(counter);
            counter = counter * 2 + 1;
        }
    }
}
