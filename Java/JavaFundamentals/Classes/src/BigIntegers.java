import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger first = new BigInteger(scan.nextLine());
        BigInteger second = new BigInteger(scan.nextLine());
        System.out.println(first.add(second));

    }
}
