import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex_Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] data = scan.nextLine().split(", ");
        HashMap<String, Integer> result = new LinkedHashMap<>();
        ArrayList<String> racers = new ArrayList<>(Arrays.asList(data));
        Pattern letterPattern = Pattern.compile("[a-z]|[A-Z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        String input = scan.nextLine();
        while (!input.equals("end of race")) {
            Matcher nameMatcher = letterPattern.matcher(input);
            StringBuilder name = new StringBuilder();
            while (nameMatcher.find()) {
                name.append(nameMatcher.group());
            }
            if (racers.contains(name.toString())) {
                result.putIfAbsent(name.toString(), 0);
                int oldKm = result.get(name.toString());
                int newKm = 0;
                Matcher digitMatcher = digitPattern.matcher(input);
                while (digitMatcher.find()) {
                    newKm += Integer.parseInt(digitMatcher.group());
                }
                result.put(name.toString(), oldKm + newKm);
            }
            input = scan.nextLine();
        }
        int[] number = {1};
        result
                .entrySet()
                .stream()
                .sorted((r1, r2) ->
                        r2.getValue().compareTo(r1.getValue()))
                .limit(3)
                .forEach(r -> {
                    switch (number[0]) {
                        case 1:
                            System.out.println(String.format("1st place: %s", r.getKey()));
                            break;
                        case 2:
                            System.out.println(String.format("2nd place: %s", r.getKey()));
                            break;
                        case 3:
                            System.out.println(String.format("3rd place: %s", r.getKey()));
                            break;
                    }
                    number[0]++;
                });
    }
}
