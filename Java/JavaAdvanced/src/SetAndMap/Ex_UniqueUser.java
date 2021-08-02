package SetAndMap;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex_UniqueUser {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> ppl = new LinkedHashSet<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String name = scan.nextLine();
            ppl.add(name);
        }
        for (String name : ppl) {
            System.out.println(name);
        }
    }
}
