package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Vat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Prices with VAT: ");
        UnaryOperator<Double> applyVat = price -> price * 1.20;
        Arrays.stream(scan.nextLine().split(", "))
                .mapToDouble(str ->applyVat.apply(Double.parseDouble(str)))
                .forEach(vatValue -> System.out.println(String.format("%.2f", vatValue)));
    }
}
