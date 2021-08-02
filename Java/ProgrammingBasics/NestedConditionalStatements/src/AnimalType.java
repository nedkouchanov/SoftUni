import java.util.Scanner;

public class AnimalType {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String animal = scan.nextLine();
        if (animal.equals("dog")){
            System.out.println("mammal");
        } else if (animal.equals("snake")){
            System.out.println("reptile");
        } else if (animal.equals("crocodile")){
            System.out.println("reptile");
        }else if (animal.equals("tortoise")){
            System.out.println("reptile");
        }
        else {
            System.out.println("unknown");
        }
    }
}
