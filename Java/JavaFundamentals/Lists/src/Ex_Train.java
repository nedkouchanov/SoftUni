import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> trains = readIntList(scan);
        int waggonCapacity = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            if (tokens[0].equals("Add")) {
                int people = Integer.parseInt(tokens[1]);
                trains.add(people);
            } else {
                int people = Integer.parseInt(tokens[0]);
                for (int i = 0; i < trains.size(); i++) {
                    int currentWaggon = trains.get(i);
                    int totalCnt = currentWaggon + people;
                    if (totalCnt <= waggonCapacity) {
                        trains.set(i, totalCnt);
                        break;
                    }
                }
            }
            input = scan.nextLine();
        }
        printTrain(trains);
    }

    private static void printTrain(List<Integer> trains) {
        for (int waggon : trains) {
            System.out.print(waggon + " ");
        }
    }

    private static List<Integer> readIntList(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> outputList = new ArrayList<>();
        for (String element : input) {
            outputList.add(Integer.parseInt(element));
        }
        return outputList;
    }
}
