package InterfacesAndAbstraction.telephony;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] numbers = scan.nextLine().split("\\s+");
        String[] urls = scan.nextLine().split("\\s+");
        Smartphone smartphone = new Smartphone(List.of(numbers), List.of(urls));
        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}
