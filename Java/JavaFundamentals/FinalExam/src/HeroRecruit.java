import java.util.*;

public class HeroRecruit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, ArrayList<String>> heroes = new HashMap<>();
        String input = scan.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];
            switch (command) {
                case "Enroll":
                    if (heroes.containsKey(heroName)) {
                        System.out.println(String.format("%s is already enrolled.", heroName));
                    } else {
                        heroes.put(heroName, new ArrayList<>());
                    }
                    break;
                case "Learn": {
                    if (heroes.containsKey(heroName)) {
                        String spellName = tokens[2];
                        ArrayList<String> spells = heroes.get((heroName));
                        if (spells.contains(spellName)) {
                            System.out.println(String.format("%s has already learnt %s.", heroName, spellName));
                        } else {
                            spells.add(spellName);
                        }
                    } else {
                        System.out.println(String.format("%s doesn't exist.", heroName));
                    }
                    break;
                }
                case "Unlearn": {
                    if (heroes.containsKey(heroName)) {
                        String spellName = tokens[2];
                        ArrayList<String> spells = heroes.get(heroName);
                        if (spells.contains(spellName)) {
                            spells.remove(spellName);
                        } else {
                            System.out.println(String.format("%s doesn't know %s.", heroName, spellName));
                        }
                    } else {
                        System.out.println(String.format("%s doesn't exist.", heroName));
                    }
                    break;
                }
            }
            input = scan.nextLine();
        }
        System.out.println("Heroes:");
        heroes
                .entrySet()
                .stream()
                .sorted((h1, h2) -> {
                    int result = h2.getValue().size() - h1.getValue().size();
                    if (result == 0) {
                        result = h1.getKey().compareTo(h2.getKey());
                    }
                    return result;
                })
                .forEach(h -> {
                    System.out.print(String.format("== %s: ", h.getKey()));
                    //System.out.println(String.join(", ", h.getValue()));
                    if (h.getValue().size() == 0) {
                        System.out.println();
                    } else {
                        for (int i = 0; i < h.getValue().size(); i++) {
                            if (i == h.getValue().size() - 1) {
                                System.out.println(h.getValue().get(i));
                            } else {
                                System.out.print(h.getValue().get(i) + ", ");
                            }
                        }
                    }
                });
    }
}

