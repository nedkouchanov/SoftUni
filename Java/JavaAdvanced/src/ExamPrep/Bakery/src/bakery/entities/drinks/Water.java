package bakery.entities.drinks;

public class Water extends BaseDrink {
    private static final double waterPrice = 1.5;

    public Water(String name, int portion, String brand) {
        super(name, portion, waterPrice, brand);
    }
}
