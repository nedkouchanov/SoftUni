package Polymorphism.animalsExt;

public class Tiger extends Felime {
    public Tiger(String animalName,
                 String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");

    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }
}
