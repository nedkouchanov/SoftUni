import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] inputNumber = scan.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < inputNumber.length; i++) {
            int current = Integer.parseInt(inputNumber[i]);
            numbers.add(current);
        }
        int iterationCount = numbers.size()/2;
        for (int i = 0; i < iterationCount; i++) {
            int lastIndex = numbers.size()-1;
            int currentSum = numbers.get(i) + numbers.get(lastIndex);
            numbers.remove(lastIndex);
            numbers.set(i,currentSum);
        }
        for (Integer number:numbers) {
            System.out.print(number+" ");

        }
    }
}
