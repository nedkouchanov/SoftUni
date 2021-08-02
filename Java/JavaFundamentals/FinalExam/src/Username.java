import java.util.Scanner;

public class Username {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Sign up")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Case":
                    String type = tokens[1];
                    if (type.equals("lower")) {
                        username = username.toLowerCase();
                        System.out.println(username);
                    } else if (type.equals("upper")) {
                        username = username.toUpperCase();
                        System.out.println(username);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && endIndex < username.length()) {
                        String result = username.substring(startIndex,endIndex+1);
                        StringBuilder substring = new StringBuilder(result);
                        substring.reverse();
                        System.out.println(substring);
                    }
                    break;
                case "Cut":
                    String substring = tokens[1];
                    if (username.contains(substring)) {
                        username = username.replace(substring, "");
                        System.out.println(username);
                    } else {
                        System.out.println(String.format("The word %s doesn't contain %s.", username, substring));
                    }
                    break;
                case "Replace": {
                    String ch = tokens[1];
                    username = username.replace(ch, "*");
                    System.out.println(username);
                    break;
                }
                case "Check": {
                    String ch = tokens[1];
                    if (username.contains(ch)) {
                        System.out.println("Valid");
                    } else {
                        System.out.println(String.format("Your username must contain %s.", ch));
                    }
                    break;
                }
            }
            input = scan.nextLine();
        }
    }
}
