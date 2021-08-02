import java.util.Scanner;

public class FruitOrVegetable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String frutveg = scan.nextLine();
        if (frutveg.equals("banana") || frutveg.equals("apple") || frutveg.equals("kiwi") ||
                frutveg.equals("cherry") || frutveg.equals("lemon") || frutveg.equals("grapes")) {
            System.out.println("fruit");
        } else if (frutveg.equals("tomato") || frutveg.equals("cucumber") || frutveg.equals("pepper") ||
                frutveg.equals("carrot")) {
            System.out.println("vegetable");
        } else {
            System.out.println("unknown");
        }
    }
}
