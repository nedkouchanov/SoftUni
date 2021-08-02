import java.util.LinkedHashMap;
import java.util.Scanner;

public class Ex_Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!"stop".equals(input)) {
            int count = Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(input, 0);
            int oldCount = resources.get(input);
            resources.put(input, oldCount + count);
            input = scan.nextLine();
        }
        resources
                .forEach((k, v) -> System.out.println
                        (String.format("%s -> %d", k, v)));
    }
}
