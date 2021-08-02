package SetAndMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> mine = new LinkedHashMap<>();
        String material = scan.nextLine();
        while (!material.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            if (!mine.containsKey(material)) {
                mine.put(material, quantity);
            } else {
                mine.put(material, mine.get(material) + quantity);
            }

            material = scan.nextLine();
        }
        for (Map.Entry<String, Integer> entry : mine.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
