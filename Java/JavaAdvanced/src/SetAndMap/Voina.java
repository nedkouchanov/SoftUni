package SetAndMap;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 2 Начина за четене на Сет от INTEGER
        LinkedHashSet<Integer> firstPlayer =
                Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds = 50;
        while (rounds-- > 0) {
            Iterator<Integer> firstIterator = firstPlayer.iterator();
            int firstCard = firstIterator.next();
            firstIterator.remove();
            Iterator<Integer> secondIterator = secondPlayer.iterator();
            int secondCard = secondIterator.next();
            secondIterator.remove();
            if (firstCard > secondCard) {
                firstPlayer.addAll(Arrays.asList(firstCard, secondCard));
            } else if (firstCard < secondCard) {
                secondPlayer.addAll(Arrays.asList(firstCard, secondCard));
            }
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
        }
        String output = "Draw!";
        if (firstPlayer.size() < secondPlayer.size()) {
            output = "Second player win!";
        } else if (firstPlayer.size() > secondPlayer.size()) {
            output = "First player win!";
        }
        System.out.println(output);
    }
}