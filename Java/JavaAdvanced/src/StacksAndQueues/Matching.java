package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Matching {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> openingSymbols = new ArrayDeque<>();
        String expression = scan.nextLine();
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (current == '(') {
                openingSymbols.push(i);
            } else if (current == ')') {
                int beginIndex = openingSymbols.pop();
                String subExpression = expression.substring(beginIndex, i + 1);
                System.out.println(subExpression);
            }
        }
    }
}
