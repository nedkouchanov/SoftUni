import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_BombNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numbers = readIntList(scan);
        String[] tokens = scan.nextLine().split("\\s+");
        int number = Integer.parseInt(tokens[0]);
        int power = Integer.parseInt(tokens[1]);
        while (numbers.contains(number)) {
            int bombIndex = numbers.indexOf(number);
            int leftBound = Math.max(bombIndex - power, 0);
            int rightBound = Math.min(bombIndex + power, numbers.size() - 1);
            for (int i = rightBound; i >= leftBound; i--) {
                numbers.remove(i);
            }
        }
        int sum = 0;
        for (Integer integer : numbers) {
            sum += integer;
        }
        System.out.println(sum);
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
