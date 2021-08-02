import java.util.Scanner;

public class NikuldenCharity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String encrypted = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Finish")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Replace":
                    encrypted = replace(encrypted, commandParts[1].charAt(0), commandParts[2].charAt(0));
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    encrypted = cut(encrypted, startIndex, endIndex);
                    break;
                case "Make":
                    encrypted = make(encrypted, commandParts[1]);
                    break;
                case "Check":
                    check(encrypted, commandParts[1]);
                    break;
                case "Sum":
                    int startSumIndex = Integer.parseInt(commandParts[1]);
                    int endSumIndex = Integer.parseInt(commandParts[2]);
                    sum(encrypted, startSumIndex, endSumIndex);
                    break;
            }
            command = scan.nextLine();
        }
    }

    private static void sum(String current, int startIndex, int endIndex) {
        if (!isValidIndex(startIndex, current.length())) {
            System.out.println("Invalid indexes!");
            return;
        } else if (!isValidIndex(endIndex, current.length())) {
            System.out.println("Invalid indexes!");
            return;
        }
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += current.charAt(i);
        }
        System.out.println(sum);
    }

    private static void check(String current, String search) {
        int searchIndex = current.indexOf(search);
        if (searchIndex == -1) {
            System.out.println("Message doesn't contain " + search);
        } else {
            System.out.println("Message contains " + search);
        }
    }

    private static String make(String current, String targetCase) {
        String result = current;
        if (targetCase.equals("Upper")) {
            result = current.toUpperCase();
        } else {
            result = current.toLowerCase();
        }
        System.out.println(result);
        return result;
    }

    private static String cut(String current, int startIndex, int endIndex) {
        if (!isValidIndex(startIndex, current.length())) {
            System.out.println("Invalid indexes!");
            return current;
        } else if (!isValidIndex(endIndex, current.length())) {
            System.out.println("Invalid indexes!");
            return current;
        }
        String firstPart = current.substring(0, startIndex);
        String secondPart = current.substring(endIndex + 1, current.length());
        String result = firstPart + secondPart;
        System.out.println(result);
        return result;
    }

    private static boolean isValidIndex(int toCheck, int length) {
        return toCheck >= 0 && toCheck < length;
    }

    private static String replace(String current, char searchFor, char replaceWith) {
        String result = current.replace(searchFor, replaceWith);
        System.out.println(result);
        return result;
    }
}
