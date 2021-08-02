
import java.util.ArrayList;
import java.util.Arrays;


class SumSet {
    static void sum_up_recursive(ArrayList<Double> numbers, double target, ArrayList<Double> partial) {
        double s = 0;
        for (double x : partial) s += x;
        //Въвеждане на желаната ТОЧНОСТ
        if (s > target + 0.001 || s < target - 0.001) {
        } else {
            if (Math.round(s) == target)
                System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + s);
        }
        for (int i = 0; i < numbers.size(); i++) {
            ArrayList<Double> remaining = new ArrayList<>();
            double n = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
            ArrayList<Double> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining, target, partial_rec);
        }
    }

    static void sum_up(ArrayList<Double> numbers, double target) {
        sum_up_recursive(numbers, target, new ArrayList<>());
    }

    public static void main(String[] args) {
        //Въвеждане на РАЗФАСОВКИ
        Double[] numbers = {0.436, 0.43, 0.216, 0.464, 0.396, 0.258, 0.458,
                0.325, 0.446, 0.156, 0.484, 0.6, 0.512, 0.494, 0.54, 0.624, 0.552, 0.502};
        //Въвеждане на ЦЕЛ
        double target = 7.0;
        sum_up(new ArrayList<>(Arrays.asList(numbers)), target);
    }
}
