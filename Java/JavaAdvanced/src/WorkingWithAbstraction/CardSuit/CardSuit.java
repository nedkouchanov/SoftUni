package WorkingWithAbstraction.CardSuit;

public enum CardSuit {
    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);
    private int ordinal;

    CardSuit(int ordinal) {
        this.ordinal = ordinal;
    }
}
