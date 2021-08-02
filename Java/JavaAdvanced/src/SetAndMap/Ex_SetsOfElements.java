package SetAndMap;

import java.sql.Array;
import java.util.*;

public class Ex_SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> first = new LinkedHashSet<>();
        Set<String> second = new LinkedHashSet<>();
        int[] firstInput = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lenFirst = firstInput[0];
        int lenSecond = firstInput[1];
        while (lenFirst-- > 0) {
            String input = scan.nextLine();
            first.add(input);
        }
        while (lenSecond-- > 0) {
            String input = scan.nextLine();
            second.add(input);
        }
        first.retainAll(second);
        for (String s : first) {
            System.out.print(s + " ");
        }
    }
}
