import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjEq {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] split = input.split(" ");
        List<Double> numbers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            double num = Double.parseDouble(split[i]);
            numbers.add(num);
        }
        for (int i = 0; i < numbers.size()-1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                double sum = numbers.get(i) * 2;
                numbers.remove(i);
                numbers.set(i,sum);
                i=-1;
            }
        }
        for (Double number:numbers) {
            System.out.print(new DecimalFormat("0.#").format(number) + " ");

        }
    }
}
