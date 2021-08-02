import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeaponSmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        List<String> weaponName = new ArrayList<>(Arrays.asList(input));
        String inputs = scan.nextLine();
        while (!inputs.equals("Done")) {
            String[] tokens = inputs.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Move": {
                    int index = Integer.parseInt(tokens[2]);
                    if (tokens[1].equals("Left")) {
                        if (index > 0 && index < weaponName.size()) {
                            String current = weaponName.get(index);
                            String leftSided = weaponName.get(index - 1);
                            weaponName.set(index - 1, current);
                            weaponName.set(index, leftSided);
                        }
                    } else if (tokens[1].equals("Right")) {
                        if (index >= 0 && index < weaponName.size() - 1) {
                            String current = weaponName.get(index);
                            String rightSided = weaponName.get(index + 1);
                            weaponName.set(index + 1, current);
                            weaponName.set(index, rightSided);
                        }
                    }
                }
                break;
                case "Check":
                    if (tokens[1].equals("Even")) {
                        for (int i = 0; i < weaponName.size(); i++) {
                            if (i % 2 == 0) {
                                System.out.print(weaponName.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (tokens[1].equals("Odd")) {
                        for (int i = 0; i < weaponName.size(); i++) {
                            if (i % 2 == 1) {
                                System.out.print(weaponName.get(i) + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }
            inputs = scan.nextLine();
        }
        String result = "";
        for (String s : weaponName) {
            result += s + "";
        }
        System.out.printf("You crafted %s!", result);
    }
}
