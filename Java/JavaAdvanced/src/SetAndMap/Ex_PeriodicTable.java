package SetAndMap;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex_PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> table = new TreeSet<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] element = scan.nextLine().split("\\s+");
            for (int i = 0; i < element.length; i++) {
                table.add(element[i]);
            }
        }
        for (String s : table) {
            System.out.print(s + " ");
        }
    }
}
