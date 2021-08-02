import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String regex = "!([A-Z][a-z]+)!:\\[([A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String message = scan.nextLine();
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                String toEncode = matcher.group(2);
                System.out.print(matcher.group(1) + ": ");
                for (int j = 0; j < toEncode.length()-1; j++) {
                    System.out.print((int) toEncode.charAt(j) + " ");
                }
                System.out.println(0+toEncode.charAt(toEncode.length() - 1));
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
