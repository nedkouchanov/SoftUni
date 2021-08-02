import java.util.*;
import java.util.stream.Collectors;

public class ArcherzTournament {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        int[] array = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        List<Integer> archery = Arrays.stream(array).boxed().collect(Collectors.toList());
        String inputs = scan.nextLine();
        int points = 0;
        while (!inputs.equals("Game over")) {
            String[] tokens = inputs.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Shoot":
                    String[] stlen = inputs.split("@");
                    String[] direction = stlen[0].split(" ");
                    String directionFinal = direction[1];
                    int startIndex = Integer.parseInt(stlen[1]);
                    if (startIndex > archery.size() || startIndex < 0) {
                        break;
                    }
                    int length = Integer.parseInt(stlen[2]);
                    if (directionFinal.equals("Left")) {
                        int indexToShoot = startIndex + length + 1;
                        for (int i = 0; i < archery.size(); i++) {
                            if (i == indexToShoot) {
                                archery.set(indexToShoot, archery.get(indexToShoot) - 5);
                                points += 5;
                            }
                        }
                    } else if (directionFinal.equals("Right")) {
                        Collections.reverse(archery);
                        for (int i = 0; i < archery.size(); i++) {
                            int indexToShoot = Math.abs(startIndex - length + 1);
                            if (i == indexToShoot) {
                                archery.set(indexToShoot, archery.get(indexToShoot) - 5);
                                points += 5;
                                Collections.reverse(archery);
                            }
                        }
                    }
                    break;
                case "Reverse":
                    Collections.reverse(archery);
                    break;

            }
            inputs = scan.nextLine();
        }
        int lastIndex = archery.size() - 1;
        String st = "";
        for (Integer s : archery) {
            System.out.print(st + s);
            st = " - ";
        }
        System.out.println();
        System.out.printf("Iskren finished the archery tournament with %d points!", points);
    }
}
