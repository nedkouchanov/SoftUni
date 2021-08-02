package SetAndMap;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        HashSet<String> carNumbers = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String command = input.substring(0, input.indexOf(","));
            String registration = input.substring(input.indexOf(",") + 2);
            if (command.equals("IN")) {
                carNumbers.add(registration);
            } else {
                carNumbers.remove(registration);
            }
            input = scan.nextLine();
        }
        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        for (String carNumber : carNumbers) {
            System.out.println(carNumber);
        }

    }
}
