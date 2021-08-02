import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Ex_Task4 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Double> priceMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> quantityMap = new LinkedHashMap<>();

        String input = scan.nextLine();
        while (!"buy".equals(input)) {

            String[] tokens = input.split("\\s+");
            String product = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            priceMap.put(product, price);

            if (quantityMap.containsKey(product)) {
                int currentQty = quantityMap.get(product);
                quantityMap.put(product, currentQty + quantity);
            } else {
                quantityMap.put(product, quantity);
            }

            input = scan.nextLine();
        }
        for (String s : priceMap.keySet()) {
            double total = priceMap.get(s) * quantityMap.get(s);
            System.out.printf("%s -> %.2f%n", s, total);
        }
    }
}
