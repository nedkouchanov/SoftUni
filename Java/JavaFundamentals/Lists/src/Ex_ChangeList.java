import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex_ChangeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputArr = scan.nextLine().split("\\s+");
        ArrayList<String> numbers = new ArrayList<>();
        for (String element : inputArr) {
            numbers.add(element);
        }
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Delete":
                    while (numbers.contains(tokens[1])) {
                        numbers.remove(tokens[1]);
                    }
                    break;
                case "Insert":
                    String element = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (index < numbers.size()) {
                        numbers.add(index, element);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.join(" ", numbers));
    }
}
