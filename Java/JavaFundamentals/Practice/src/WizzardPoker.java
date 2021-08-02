import java.util.*;

public class WizzardPoker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(":");
        List<String> cards = new ArrayList<>(Arrays.asList(input));
        List<String> newCards = new ArrayList<>();
        String inputs = scan.nextLine();
        while (!inputs.equals("Ready")) {
            String[] tokens = inputs.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    if (cards.contains(tokens[1])) {
                        newCards.add(tokens[1]);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (cards.contains(tokens[1]) && index >= 0 && index < newCards.size()) {
                        newCards.add(index, tokens[1]);
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    if (newCards.contains(tokens[1])) {
                        newCards.remove(tokens[1]);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    int card1Index = newCards.indexOf(tokens[1]);
                    int card2Index = newCards.indexOf(tokens[2]);
                    if (card1Index >= 0 && card1Index < newCards.size()
                            && card2Index >= 0 && card2Index < newCards.size()) {
                        String temp = tokens[2];
                        newCards.set(card1Index, temp);
                        newCards.set(card2Index, tokens[1]);
                    }
                    break;
                case "Shuffle":
                    if (tokens[1].equals("deck")) {
                        Collections.reverse(newCards);
                    }
                    break;
            }
            inputs = scan.nextLine();
        }
        for (String card : newCards) {
            System.out.print(card + " ");
        }
    }
}
