package Polymorphism.animalsExt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//NOT FINISHED!!!
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        String line;
        while (!(line = scan.nextLine()).equals("END")) {
            String[] animalInfo = line.split("\\s+");
            Animal animal = createAnimal(animalInfo);
            line = scan.nextLine();
            String[] foodInfo = line.split("\\s+");
            animals.add(animal);
        }
    }

    private static Animal createAnimal(String[] animalInfo) {
        switch (animalInfo[0]) {
            case "Polymorphism.animalsExt.Cat":
                return new Cat(animalInfo[1], animalInfo[2],
                        Double.parseDouble(animalInfo[3]),
                        animalInfo[4], animalInfo[5]);
            case "Polymorphism.animalsExt.Tiger":
                return new Tiger(animalInfo[1], animalInfo[2],
                        Double.parseDouble(animalInfo[3]),
                        animalInfo[4]);
            case "Polymorphism.animalsExt.Mouse":
                return new Mouse(animalInfo[1], animalInfo[2],
                        Double.parseDouble(animalInfo[3]),
                        animalInfo[4]);
            case "Polymorphism.animalsExt.Zebra":
                return new Zebra(animalInfo[1], animalInfo[2],
                        Double.parseDouble(animalInfo[3]),
                        animalInfo[4]);
        }
        return null;
    }
}
