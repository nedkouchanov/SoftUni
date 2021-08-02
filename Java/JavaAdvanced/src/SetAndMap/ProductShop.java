package SetAndMap;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Map<String, Double>> shopProd = new TreeMap<>();
        String input = scan.nextLine();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            input = scan.nextLine();
            if (!shopProd.containsKey(shop)) {
                shopProd.put(shop, new LinkedHashMap<>());
                shopProd.get(shop).put(product, price);
            } else {
                shopProd.get(shop).put(product, price);
            }
        }
        for (Map.Entry<String, Map<String, Double>> entry : shopProd.entrySet()) {
            System.out.println(entry.getKey() + "->");
            for (Map.Entry<String, Double> inner : entry.getValue().entrySet()) {
                System.out.println(String.format("Product: %s, Price: %.1f", inner.getKey(), inner.getValue()));
            }
        }
    }
}
