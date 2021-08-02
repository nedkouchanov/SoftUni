package Polymorphism.animalsExt;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalName, String animalType,
                     Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        String animal = this.getClass().getSimpleName();
        boolean isValid = true;
        if (food.getClass().getSimpleName().equals("Polymorphism.animalsExt.Vegetable")) {
            if (animal.equals("Polymorphism.animalsExt.Tiger")) {
                isValid = false;
            }
        } else {
            if (animal.equals("Polymorphism.animalsExt.Mouse") || animal.equals("Polymorphism.animalsExt.Zebra")) {
                isValid = false;
            }
        }
        if (isValid) {
            super.setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            System.out.printf
                    ("%s are not eating this type of food!%n", animal);
        }
    }
}
