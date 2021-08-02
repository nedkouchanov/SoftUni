package Encapsulation.PizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double flourModifier;
    private double bakingModifier;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
                this.flourModifier = 1.5;
                this.flourType = flourType;
                break;
            case "Wholegrain":
                this.flourModifier = 1.0;
                this.flourType = flourType;
                break;
            default:
                throw new IllegalArgumentException
                        ("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                this.bakingModifier = 0.9;
                this.bakingTechnique = bakingTechnique;
                break;
            case "Chewy":
                this.bakingModifier = 1.1;
                this.bakingTechnique = bakingTechnique;
                break;
            case "Homemade":
                this.bakingModifier = 1.0;
                this.bakingTechnique = bakingTechnique;
                break;
            default:
                throw new IllegalArgumentException
                        ("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException
                    ("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return (2 * this.weight) *
                this.flourModifier * this.bakingModifier;
    }
}
