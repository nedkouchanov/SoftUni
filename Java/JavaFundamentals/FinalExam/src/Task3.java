import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String cities = scan.nextLine();
        HashMap<String, Integer> people = new HashMap<>();
        HashMap<String, Integer> gold = new HashMap<>();
        while (!"Sail".equals(cities)) {
            String[] tokens = cities.split("\\|\\|");
            String town = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int goldIn = Integer.parseInt(tokens[2]);
            if (!people.containsKey(town)) {
                people.put(town, population);
                gold.put(town, goldIn);
            } else {
                Integer currentPeople = people.get(town);
                Integer currentGold = gold.get(town);
                if (currentPeople != null) {
                    people.put(town, currentPeople + population);
                    gold.put(town, currentGold + goldIn);
                } else {
                    people.put(town, population);
                    gold.put(town, currentGold + goldIn);
                }
            }
            cities = scan.nextLine();
        }
        String events = scan.nextLine();
        while (!events.equals("End")) {
            String[] tokens = events.split("=>");
            String command = tokens[0];
            String town = tokens[1];
            if (command.equals("Plunder")) {
                int oldPeople = people.get(town);
                int oldGold = gold.get(town);
                int peoplePlu = Integer.parseInt(tokens[2]);
                int goldPlu = Integer.parseInt(tokens[3]);
                System.out.println(String.format
                        ("%s plundered! %d gold stolen, %d citizens killed.", town, goldPlu, peoplePlu));
                people.put(town, oldPeople - peoplePlu);
                gold.put(town, oldGold - goldPlu);
                if (people.get(town) == 0 || gold.get(town) == 0) {
                    people.remove(town);
                    gold.remove(town);
                    System.out.println(String.format("%s has been wiped off the map!", town));
                }
            } else if (command.equals("Prosper")) {
                int goldPlu = Integer.parseInt(tokens[2]);
                if (goldPlu < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    int oldGold = gold.get(town);
                    gold.put(town, oldGold + goldPlu);
                    System.out.println(String.format
                            ("%d gold added to the city treasury. %s now has %d gold.", goldPlu, town, gold.get(town)));
                }
            }
            events = scan.nextLine();
        }
        int count = people.size();
        if (count == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.println(String.format("Ahoy, Captain! There are %d wealthy settlements to go to:", count));
        }
        gold
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    String town = entry.getKey();
                    int gld = entry.getValue();
                    int ppl = people.get(town);
                    System.out.println(String.format("%s -> Population: %d citizens, Gold: %d kg", town, ppl, gld));
                });
    }
}
