import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstnum = Integer.parseInt(scan.nextLine());
        int secondnum = Integer.parseInt(scan.nextLine());
        if (firstnum >= secondnum){
            System.out.println(firstnum);
        } else {
            System.out.println(secondnum);
        }
    }
}
