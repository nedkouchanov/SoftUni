import java.util.Scanner;

public class Spaceship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double width = Double.parseDouble(scan.nextLine());
        double length = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double avgHeightAstro = Double.parseDouble(scan.nextLine());
        double volume = width * height * length;
        double volumeRoom = (avgHeightAstro + 0.4) * 2 * 2;
        double austroCount = Math.floor(volume / volumeRoom);
        if (austroCount >= 3 && austroCount <= 10) {
            System.out.printf("The spacecraft holds %.0f astronauts.", austroCount);
        } else if (austroCount < 3) {
            System.out.println("The spacecraft is too small.");
        } else if (austroCount > 10) {
            System.out.println("The spacecraft is too big.");
        }
    }
}
