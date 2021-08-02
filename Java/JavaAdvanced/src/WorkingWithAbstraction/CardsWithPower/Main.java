package WorkingWithAbstraction.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String rank = scan.nextLine();
        String suit = scan.nextLine();

        CardRank cardRank = CardRank.valueOf(rank);
        CardSuit cardSuit = CardSuit.valueOf(suit);
        int power = cardRank.getOrdinal() + cardSuit.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit, power);
    }
}
