package FunctionalProgramming;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUpperCase {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        Predicate<String> predicate = str -> Character.isUpperCase(str.charAt(0));
        StringBuilder out = new StringBuilder();
        AtomicInteger counter = new AtomicInteger(0);
        Consumer<String> appender = str -> {
            counter.incrementAndGet();
            out.append(str).append(System.lineSeparator());

        };


        Arrays.stream(text.split("\\s+"))
                .filter(predicate)
                .forEach(appender);
        System.out.println(counter);
        System.out.println(out.toString());
    }
}
