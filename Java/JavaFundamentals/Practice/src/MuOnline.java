import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        int health = 100;
        int bitCoins = 0;
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        boolean flag = true;
        String[] tokens = input.split("\\|");
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            String[] current = token.split("\\s+");
            String command = current[0];
            int intInput = Integer.parseInt(current[1]);
            if (flag) {
                switch (command) {
                    case "potion": {
                        int overH = 0;
                        int currentH = health;
                        if (health < 100) {
                            overH = (100 - currentH);
                            health += intInput;
                            if (health > 100) {
                                health = 100;
                            } else {
                                overH = intInput;
                            }
                        }
                        System.out.println(String.format("You healed for %d hp.", overH));
                        System.out.println(String.format("Current health: %d hp.", health));
                        break;
                    }
                    case "chest":
                        System.out.println(String.format("You found %d bitcoins.", intInput));
                        bitCoins += intInput;
                        break;
                    default:
                        health -= intInput;
                        if (health <= 0) {
                            System.out.println(String.format("You died! Killed by %s.", command));
                            System.out.println(String.format("Best room: %d", i + 1));
                            flag = false;
                        } else {
                            System.out.println(String.format("You slayed %s.", command));
                        }
                        break;
                }
            }
        }
        if (flag) {
            System.out.println("You've made it!");
            System.out.println(String.format("Bitcoins: %d%nHealth: %d", bitCoins, health));
        }
    }
}

