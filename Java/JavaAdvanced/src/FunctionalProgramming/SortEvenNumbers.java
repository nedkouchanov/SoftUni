package FunctionalProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .toArray();
        IntConsumer consumer = num -> System.out.print(num + " ");

        print(numbers);

        Arrays.sort(numbers);

        print(numbers);
    }

    private static void print(int[] numbers) {
        System.out.println(Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
