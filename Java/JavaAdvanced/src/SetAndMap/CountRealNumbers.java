package SetAndMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] values = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer> numbers = new LinkedHashMap<>();
        for (double value : values) {
            if (!numbers.containsKey(value)) {
                numbers.put(value, 1);
            } else {
                numbers.put(value, numbers.get(value) + 1);
            }
        }
        for (Double key : numbers.keySet()) {
            System.out.println(String.format("%.1f -> %d", key, numbers.get(key)));
        }

    }
}
