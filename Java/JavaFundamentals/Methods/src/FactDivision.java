import java.util.Scanner;

public class FactDivision {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = Integer.parseInt(scan.nextLine());
        int second = Integer.parseInt(scan.nextLine());
        factDiv(first,second);
    }

    private static void factDiv(int first, int second) {
        int firstFact = 1;
        int secondFact = 1;
        while (first > 0) {
            firstFact *= first;
            first--;
        }
        while (second > 0) {
            secondFact *= second;
            second--;
        }
        double result = firstFact/secondFact;
        System.out.printf("%.2f",result);
    }
}
