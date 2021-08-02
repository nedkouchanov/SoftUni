import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile(("^(.+)>([\\d]{3})\\|([a-z]{3})\\|([A-Z]{3})\\|([^<>]{3})<\\1$"));
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                sb.append(matcher.group(2));
                sb.append(matcher.group(3));
                sb.append(matcher.group(4));
                sb.append(matcher.group(5));
                System.out.println("Password: " + sb.toString());
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
