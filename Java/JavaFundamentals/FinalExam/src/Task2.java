import com.sun.source.tree.BinaryTree;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([:\\*]{2})([A-Z][a-z]{2,})\\1|(?<number>\\d)");
        String input = scan.nextLine();
        int EmojiAskii = 0;
        input = input.replace(" ", "");
        LinkedHashMap<String, Integer> coolOnes = new LinkedHashMap<>();
        Matcher matcher = pattern.matcher(input);
        BigInteger sum = new BigInteger("1");
        int countEmj = 0;
        while (matcher.find()) {
            String currentEmoji = matcher.group(2);
            if (currentEmoji == null) {
                String currentNum = matcher.group(3);
                BigInteger digit = new BigInteger(currentNum);
                sum = sum.multiply(digit);
            } else {
                countEmj++;
                String remember = matcher.group(0);

                for (int j = 0; j < currentEmoji.length(); j++) {
                    int currentEmojiAskii = (int) currentEmoji.charAt(j);
                    EmojiAskii += currentEmojiAskii;
                }
                coolOnes.put(remember, EmojiAskii);
            }
        }


        BigInteger finalSum = sum;
        System.out.println(String.format("Cool threshold: %d", sum));
        coolOnes.values().removeIf(value -> BigInteger.valueOf(value).compareTo(finalSum) < 0);
        System.out.println(String.format("%d emojis found in the text. The cool ones are:", countEmj));
        coolOnes
                .entrySet()
                .stream()
                .forEach(t -> {
                    System.out.println(t.getKey());
                });
    }
}
