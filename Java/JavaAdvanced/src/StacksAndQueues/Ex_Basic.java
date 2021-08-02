package StacksAndQueues;

import java.util.*;

public class Ex_Basic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int numbersRemove = input[1];
        int target = input[2];
        for (int i = 0; i < n; i++) {
            stack.push(scan.nextInt());
        }
        for (int i = 0; i < numbersRemove; i++) {
            stack.pop();
        }
        if (stack.contains(target)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
