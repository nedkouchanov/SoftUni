import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FriendList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int blackListCnt = 0;
        int lostCnt = 0;
        boolean flag = false;
        String[] input = scan.nextLine().split(", ");
        List<String> friends = new ArrayList<>(Arrays.asList(input));
        String inputs = scan.nextLine();
        while (!inputs.equals("Report")) {
            String[] tokens = inputs.split("\\s+");
            String command = tokens[0];
            if (command.equals("Blacklist")) {
                String name = tokens[1];
                for (int i = 0; i < friends.size(); i++) {
                    if (name.equals(friends.get(i))) {
                        System.out.printf("%s was blacklisted.%n", friends.get(i));
                        friends.set(i, "Blacklisted");
                        flag = true;
                        blackListCnt++;
                    }
                }
                if (!flag)
                    System.out.printf("%s was not found.%n", name);
            } else if (command.equals("Error")) {
                int index = Integer.parseInt(tokens[1]);
                if (!friends.get(index).equals("Blacklisted") && !friends.get(index).equals("Lost")) {
                    System.out.printf("%s was lost due to an error.%n", friends.get(index));
                    friends.set(index, "Lost");
                    lostCnt++;
                }
            } else if (command.equals("Change")) {
                int index = Integer.parseInt(tokens[1]);
                String newName = tokens[2];
                if (index < friends.size() && index >= 0) {
                    System.out.printf("%s changed his username to %s.%n", friends.get(index), newName);
                    friends.set(index, newName);
                }
            }
            inputs = scan.nextLine();
        }
        System.out.printf("Blacklisted names: %s%n", blackListCnt);
        System.out.printf("Lost names: %s%n", lostCnt);
        for (String name : friends) {
            System.out.print(name + " ");
        }
    }
}
