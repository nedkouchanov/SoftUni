import java.util.*;

public class Frogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        ArrayList<String> frogs = new ArrayList<>(Arrays.asList(input));
        String inputs = scan.nextLine();
        while (true) {
            String[] tokens = inputs.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Join":
                    String frogToJoin = tokens[1];
                    frogs.add(frogToJoin);
                    break;
                case "Jump":
                    String frogToJump = tokens[1];
                    int indexToJump = Integer.parseInt(tokens[2]);
                    if (indexToJump < frogs.size() && indexToJump >= 0) {
                        frogs.add(indexToJump, frogToJump);
                    }
                    break;
                case "Dive":
                    int indexToDive = Integer.parseInt(tokens[1]);
                    if (indexToDive < frogs.size() && indexToDive >= 0) {
                        frogs.remove(indexToDive);
                    }
                    break;
                case "First": {
                    int count = Integer.parseInt(tokens[1]);
                    for (String frog : frogs) {
                        for (int i = 0; i < count; i++) {
                            System.out.print(frog + " ");
                            break;
                        }
                    }
                    break;
                }
                case "Last": {
                    int count = Integer.parseInt(tokens[1]);
                    for (int i = frogs.size() - count; i < frogs.size(); i++) {
                        for (String frog : frogs) {
                            System.out.print((frogs.get(i) + " "));
                            break;
                        }
                    }
                }
            }
            if (inputs.equals("Print Normal")) {
                System.out.println();
                System.out.print("Frogs: ");
                for (String frog : frogs
                ) {
                    System.out.print(frog + " ");
                }
                break;
            } else if (inputs.equals("Print Reversed")) {
                System.out.println();
                System.out.print("Frogs: ");
                Collections.reverse(frogs);
                for (String frog : frogs
                ) {
                    System.out.print(frog + " ");
                }
                break;
            }
            inputs = scan.nextLine();
        }
    }
}
