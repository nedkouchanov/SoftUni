import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] itAr = scan.nextLine().split(", ");
        ArrayList<String> items = new ArrayList<>(Arrays.asList(itAr));
        String input = scan.nextLine();
        while (!input.equals("Craft!")) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String oItem = tokens[1];
            switch (command) {
                case "Collect":
                    if (!items.contains(oItem)) {
                        items.add(oItem);
                    }
                    break;
                case "Drop":
                    if (items.contains(oItem)) {
                        items.remove(oItem);
                    }
                    break;
                case "Combine Items":
                    String[] itemsTo = oItem.split(":");
                    String oldItem = itemsTo[0];
                    String newItem = itemsTo[1];
                    if (items.contains(oldItem)) {
                        int index = items.indexOf(oldItem);
                        items.add(index + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(oItem)) {
                        items.remove(oItem);
                        items.add(oItem);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        String sep = "";
        for (String item : items) {
            System.out.print(sep + item);
            sep = ", ";
        }

    }
}
