import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = scan.nextLine();
            String syn = scan.nextLine();
            //init
            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(syn);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(),
                    String.join(", ", entry.getValue()));
        }
    }
}
