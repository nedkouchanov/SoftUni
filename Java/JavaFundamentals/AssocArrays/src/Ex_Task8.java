import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex_Task8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String, ArrayList<String>> companies = new TreeMap<>();
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String id = tokens[1];
            companies.putIfAbsent(company, new ArrayList<>());
            if (!companies.get(company).contains(id)) {
                companies.get(company).add(id);
            }

            input = scan.nextLine();
        }
        companies
                .entrySet()
                .forEach(c -> {
                    System.out.println(String.format("%s", c.getKey()));
                    c.getValue().forEach(s -> System.out.println(String.format("-- %s", s)));
                });
    }
}
