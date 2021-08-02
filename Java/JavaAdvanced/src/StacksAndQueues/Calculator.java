package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] expression = scan.nextLine().split("\\s+");
        for (int i = expression.length - 1; i >= 0; i--) {
            stack.push(expression[i]);
        }
        int result;
        while (!(stack.size() == 1)) {
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());
            if (operator.equals("+")) {
                result = first + second;
            } else {
                result = first - second;
            }
            String resultToPush = result + "";
            stack.push(resultToPush);
        }
        System.out.println(stack.pop());
    }
}
