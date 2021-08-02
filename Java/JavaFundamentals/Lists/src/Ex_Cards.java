import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex_Cards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> cards1 = readIntList(scan);
        List<Integer> cards2 = readIntList(scan);
        int card1Cnt = 0;
        int card2Cnt = 0;
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < cards1.size(); i++) {
            for (Integer integer : cards2) {
                int currentSum = cards1.get(i) + integer;
                if (cards1.get(i) > cards2.get(i)) {
                    card1Cnt++;
                    sum1 += currentSum;

                } else if (cards1.get(i) == cards2.get(i)) {
                } else {
                    card2Cnt++;
                    sum2 += currentSum;
                }
                currentSum = 0;
            }
        }
        if (card1Cnt > card2Cnt) {
            System.out.printf("First player wins! Sum: %d", sum1);
        } else if (card1Cnt < card2Cnt) {
            System.out.printf("Second player wins! Sum: %d", sum2);
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
