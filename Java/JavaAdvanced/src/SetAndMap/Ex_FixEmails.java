package SetAndMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();
        String name = scan.nextLine();

        while (!name.equals("stop")) {
            String afterDot = "";
            String email = scan.nextLine();
            afterDot = email.substring(email.indexOf("."));

            if (!afterDot.equals(".us") && !afterDot.equals(".uk")
                    && !afterDot.equals(".com")) {
                emails.put(name, email);
            }
            name = scan.nextLine();
        }
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
