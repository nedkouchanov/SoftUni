import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String email = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("Complete")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Make":
                    if ("Upper".equals(tokens[1])) {
                        email = email.toUpperCase();
                        System.out.println(email);
                    } else if ("Lower".equals(tokens[1])) {
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;
                case "GetDomain":
                    int cnt = Integer.parseInt(tokens[1]);
                    int firstToPrint = email.length() - cnt;
                    for (int i = firstToPrint; i < email.length(); i++) {
                        System.out.print(email.charAt(i));
                    }
                    System.out.println();
                    break;
                case "GetUsername":
                    StringBuilder str = new StringBuilder();
                    if (email.contains("@")) {
                        int index = email.indexOf("@");
                        for (int i = 0; i < index; i++) {
                            System.out.print(email.charAt(i));
                        }
                        System.out.println();
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n",email);
                    }
                    break;
                case "Replace":
                    String ch = tokens[1];
                    System.out.println(email.replaceAll(ch, "-"));
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length(); i++) {
                        char chr = email.charAt(i);
                        System.out.print((int) chr + " ");
                    }
                    break;
            }
            input = scan.nextLine();
        }
    }
}
