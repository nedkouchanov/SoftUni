package InterfacesAndAbstraction.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Rebel> rebels = new ArrayList<>();
        List<Citizen> citizens = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String line = scan.nextLine();
            String[] tokens = line.split("\\s+");
            switch (tokens.length) {
                case 4:
                    Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
                    citizens.add(citizen);
                    break;
                case 3:
                    Rebel rebel = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    rebels.add(rebel);
                    break;
            }
        }
        String name = scan.nextLine();
        while (!name.equals("End")) {
            for (Citizen citizen : citizens) {
                if (name.equals(citizen.getName())) {
                    citizen.buyFood();
                }
            }
            for (Rebel rebel : rebels) {
                if (name.equals(rebel.getName())) {
                    rebel.buyFood();
                }
            }
            name = scan.nextLine();
        }
        int foodC = 0;
        int foodR = 0;
        for (Citizen citizen : citizens) {
            foodC += citizen.getFood();
        }
        for (Rebel rebel : rebels) {
            foodR += rebel.getFood();
        }
        System.out.println(foodC + foodR);
    }

}