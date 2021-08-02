import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("!");
        List<String> groceries = new ArrayList<>(Arrays.asList(input));
        String inputs = scan.nextLine();
        while (!inputs.equals("Go Shopping!")) {
            String[] tokens = inputs.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Urgent":
                    if (!groceries.contains(tokens[1])) {
                        groceries.add(0, tokens[1]);
                    }
                    break;
                case "Unnecessary":
                    if (groceries.contains(tokens[1])) {
                        groceries.remove(tokens[1]);
                    }
                    break;
                case "Correct":
                    if (groceries.contains(tokens[1])) {
                        int temp = groceries.indexOf(tokens[1]);
                        groceries.set(temp, tokens[2]);
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(tokens[1])) {
                        String temp = tokens[1];
                        groceries.remove(tokens[1]);
                        groceries.add(groceries.size(), temp);
                    }
                    break;
            }
            inputs = scan.nextLine();
        }
        System.out.print(String.join(", ", groceries));
    }
}

