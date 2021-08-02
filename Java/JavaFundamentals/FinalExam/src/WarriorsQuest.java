import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("For Azeroth")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "GladiatorStance":
                    string = string.toUpperCase();
                    System.out.println(string);
                    break;
                case "DefensiveStance":
                    string = string.toLowerCase();
                    System.out.println(string);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];
                    if (index >= 0 && index < string.length()) {
                        StringBuilder sb = new StringBuilder(string);
                        sb.replace(index, index + 1, letter);
                        string = sb.toString();
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":
                    if (tokens[1].equals("Change")) {
                        String firstSubstr = tokens[2];
                        String secondSubstr = tokens[3];
                        string = string.replace(firstSubstr, secondSubstr);
                        System.out.println(string);
                    } else if (tokens[1].equals("Remove")) {
                        String substring = tokens[2];
                        string = string.replace(substring, "");
                        System.out.println(string);
                    } else {
                        System.out.println("Command doesn't exist!");
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }
            input = scan.nextLine();
        }
    }
}
