import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex_Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double income = 0.0;
        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]+)%(?:[^|$%.]*)<(?<product>" +
                "[^<>]+)>(?:[^|$%.]*)\\|(?<count>\\d+)\\|(?:[^|$%.]*?)(?<price>[-+]?\\d+\\.?\\d+)\\$");
        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));
                double totalPrice = count * price;
                income += totalPrice;

                System.out.printf("%s: %s - %.2f%n", name, product, totalPrice);
            }
            input = scan.nextLine();
        }
        System.out.printf("Total income: %.2f", income);
    }
}
