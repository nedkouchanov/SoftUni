import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] split = scan.nextLine().split("\\|");
        List<String> chest = new ArrayList<>(Arrays.asList(split));
        String input = scan.nextLine();
        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (!chest.contains(tokens[i])) {
                            chest.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index < 0 || index >= chest.size()) {
                        break;
                    }
                    String element = chest.remove(index);
                    chest.add(element);
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    if (count >= chest.size()) {
                        String output = String.join(", ", chest);
                        System.out.println(output);
                        chest.clear();
                        break;
                    }
                    List<String> stolen = new ArrayList<>();
                    for (int i = 0; i < count; i++) {
                        int lastIndex = chest.size() - 1;
                        stolen.add((chest.remove(lastIndex)));
                    }
                    Collections.reverse(stolen);
                    String output = String.join(", ", stolen);
                    System.out.println(output);
                    break;
            }
            input = scan.nextLine();
        }
        if (chest.size() > 0) {
            double lengthSum = 0;
            for (String s : chest) {
                lengthSum += s.length();
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.",
                    (lengthSum * 1.0) / chest.size());
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}

