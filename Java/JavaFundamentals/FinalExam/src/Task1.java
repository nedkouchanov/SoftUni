import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String key = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Generate")) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];
            switch (command) {
                case "Contains": {
                    String substring = tokens[1];
                    if (key.contains(substring)) {
                        System.out.println(String.format("%s contains %s", key, substring));
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                }
                case "Flip": {
                    int startIndex = Integer.parseInt(tokens[2]);
                    int endIndex = Integer.parseInt(tokens[3]);
                    String substringOld = key.substring(startIndex, endIndex);
                    String substring = key.substring(startIndex, endIndex);
                    if (tokens[1].equals("Upper")) {
                        substring = substring.toUpperCase();
                    } else if (tokens[1].equals("Lower")) {
                        substring = substring.toLowerCase();
                    }
                    for (int i = startIndex; i < endIndex; i++) {
                        key = key.replace(substringOld, substring);
                    }
                    System.out.println(key);
                    break;
                }
                case "Slice":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    String substring = key.substring(startIndex, endIndex);
                    key = key.replace(substring, "");
                    System.out.println(key);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.format("Your activation key is: %s", key));
    }
}
