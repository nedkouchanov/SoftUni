import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String giftStr = scan.nextLine();
        String[] giftsArr = giftStr.split("\\s+");
        ArrayList<String> gifts = new ArrayList<>(Arrays.asList(giftsArr));
        String input = scan.nextLine();
        while (!input.equals("No Money")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String gift = tokens[1];
            switch (command) {
                case "OutOfStock": {
                    while (gifts.contains(gift)) {
                        int index = gifts.indexOf(gift);
                        gifts.remove(gift);
                        gifts.add(index, "None");
                    }
                    break;
                }
                case "Required": {
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < gifts.size()) {
                        String currentG = gifts.get(index);
                        gifts.remove(currentG);
                        gifts.add(index, gift);
                    }
                    break;
                }
                case "JustInCase":
                    int lastGiftInd = gifts.size() - 1;
                    String lastG = gifts.get(lastGiftInd);
                    gifts.remove(lastG);
                    gifts.add(gift);
                    break;
            }
            input = scan.nextLine();
        }
        for (String gift : gifts) {
            if (!gift.equals("None")) {
                System.out.print(gift + " ");
            }
        }
    }
}
