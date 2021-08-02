package Polymorphism.animalsExt;

public class Mouse extends Mammal {
    public Mouse(String animalName,
                 String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");

    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }
}
