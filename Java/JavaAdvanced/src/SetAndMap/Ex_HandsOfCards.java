package SetAndMap;

import java.lang.reflect.Array;
import java.util.*;

public class Ex_HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, LinkedHashSet<String>> players = new LinkedHashMap<>();
        String line = "";
        while (!(line = scan.nextLine()).equals("JOKER")) {
            String[] tokens = line.split(": ");
            String name = tokens[0];
            String[] hand = tokens[1].split(", ");
            if (!players.containsKey(name)) {
                players.put(name, new LinkedHashSet<>());
            }
            LinkedHashSet<String> strings = players.get(name);
            strings.addAll(Arrays.asList(hand));
            players.put(name, strings);
        }
        players.forEach((key, value) -> {
            int totalPower = 0;
            for (String card : value) {
                totalPower +=
                        getPower(card.substring(0, card.length() - 1)) *
                                getMultiplier(card.substring(card.length() - 1));
            }
            System.out.printf("%s: %d%n", key, totalPower);
        });
    }

    private static int getPower(String power) {
        switch (power) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return 0;
        }
    }

    private static int getMultiplier(String type) {
        switch (type) {
            case "C":
                return 1;
            case "D":
                return 2;
            case "H":
                return 3;
            case "S":
                return 4;
            default:
                return 0;
        }
    }
}


