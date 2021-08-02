import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class School {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("&");
        ArrayList<String> books = new ArrayList<>(Arrays.asList(input));
        String inputs = scan.nextLine();
        while (!inputs.equals("Done")) {
            String[] tokens = inputs.split(" \\| ");
            String command = tokens[0];
            switch (command) {
                case "Add Book":
                    if (!books.contains(tokens[1])) {

                        books.add(0, tokens[1]);
                    }
                    break;
                case "Take Book":
                    if (books.contains(tokens[1])) {
                        books.remove(tokens[1]);
                    }
                    break;
                case "Swap Books":
                    if (books.contains(tokens[1]) && (books.contains(tokens[2]))) {
                        String temp = books.get(books.indexOf(tokens[1]));
                        books.set(books.indexOf(tokens[1]), tokens[2]);
                        books.set(books.indexOf(tokens[2]), temp);
                    }
                    break;
                case "Insert Book":
                    books.add(books.size(), tokens[1]);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index >= books.size()) {
                        break;
                    }
                    System.out.println(books.get(index));
                    break;
            }

            inputs = scan.nextLine();
        }
        System.out.print(String.join(", ",books));
    }
}
