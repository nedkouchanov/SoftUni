package Polymorphism.animalsExt;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");

    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }
}
