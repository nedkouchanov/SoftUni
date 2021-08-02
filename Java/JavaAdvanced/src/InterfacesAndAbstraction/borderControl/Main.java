package InterfacesAndAbstraction.borderControl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Identifiable> identifiables = new ArrayList<>();
        String line = scan.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            Identifiable current;
            if (tokens.length == 3) {
                current = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else {
                current = new Robot(tokens[0], tokens[1]);
            }
            identifiables.add(current);
            line = scan.nextLine();

        }
        String fakeId = scan.nextLine();
        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(fakeId)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
