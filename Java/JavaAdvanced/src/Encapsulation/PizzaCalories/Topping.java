package Encapsulation.PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;
    private double toppingModifier;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Polymorphism.animalsExt.Meat":
                this.toppingModifier = 1.2;
                this.toppingType = toppingType;
                break;
            case "Veggies":
                this.toppingModifier = 0.8;
                this.toppingType = toppingType;
                break;
            case "Cheese":
                this.toppingModifier = 1.1;
                this.toppingType = toppingType;
                break;
            case "Sauce":
                this.toppingModifier = 0.9;
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException
                        (String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException
                    (String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.weight) * this.toppingModifier;
    }
}
