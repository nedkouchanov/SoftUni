package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine()
                .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], int[]> printCount = arr -> {
            System.out.println("Count = " + arr.length);
            return arr;
        };
        Function<int[], String> formatArrSum = arr ->
                "Sum = " + Arrays.stream(arr)
                        .sum();
        System.out.println(printCount
                .andThen(formatArrSum)
                .apply(numbers));

    }
}
