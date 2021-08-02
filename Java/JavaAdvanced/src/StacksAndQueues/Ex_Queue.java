package StacksAndQueues;

import java.util.*;

public class Ex_Queue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int numbersRemove = input[1];
        int target = input[2];
        for (int i = 0; i < n; i++) {
            queue.offer(scan.nextInt());
        }
        for (int i = 0; i < numbersRemove; i++) {
            queue.poll();
        }
        if (queue.contains(target)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
