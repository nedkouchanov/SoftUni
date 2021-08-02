import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double coins = Double.parseDouble(scan.nextLine());
        double toInt = coins * 100;
        int coinsFinal = (int)toInt;
        int count = 0;
        while (coinsFinal > 0) {
            if (coinsFinal >= 200) {
                coinsFinal -= 200;
                count++;
            } else if (coinsFinal >= 100) {
                coinsFinal -= 100;
                count++;
            } else if (coinsFinal >= 50) {
                coinsFinal -= 50;
                count++;
            } else if (coinsFinal >= 20) {
                coinsFinal -= 20;
                count++;
            } else if (coinsFinal >= 10) {
                coinsFinal -=10;
                count++;
            } else if (coinsFinal >= 5) {
                coinsFinal -= 5;
                count++;
            } else if (coinsFinal >= 2) {
                coinsFinal -= 2;
                count++;
            } else if (coinsFinal >= 1) {
                coinsFinal -= 1;
                count++;
            }
        }
        System.out.println(count);
    }
}