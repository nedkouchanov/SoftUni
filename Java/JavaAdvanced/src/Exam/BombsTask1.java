package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BombsTask1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;
        boolean pouchFull = false;

        int[] lineOfNumbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        //queue
        ArrayDeque<Integer> queueBombEffects = new ArrayDeque<>();
        for (int num : lineOfNumbers) {
            queueBombEffects.offer(num);
        }
        lineOfNumbers = Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        //stack
        ArrayDeque<Integer> stackBombCasings = new ArrayDeque<>();
        for (int num : lineOfNumbers) {
            stackBombCasings.push(num);
        }
        while (!queueBombEffects.isEmpty()
                && !stackBombCasings.isEmpty()) {
            int sum = queueBombEffects.peek() + stackBombCasings.peek();
            if (sum == 40) {
                daturaBombs++;
                queueBombEffects.poll();
                stackBombCasings.pop();
            } else if (sum == 60) {
                queueBombEffects.poll();
                stackBombCasings.pop();
                cherryBombs++;
            } else if (sum == 120) {
                queueBombEffects.poll();
                stackBombCasings.pop();
                smokeDecoyBombs++;
            } else {
                int currentCasing = stackBombCasings.pop();
                stackBombCasings.push(currentCasing - 5);
            }
            if (queueBombEffects.size() == 0 || stackBombCasings.size() == 0) {
                break;
            }
            if (daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3) {
                pouchFull = true;
                break;
            }
        }
        if (pouchFull) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (queueBombEffects.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            String sep = "";
            for (int i = 0; i <= queueBombEffects.size(); i++) {
                System.out.print(sep + queueBombEffects.poll());
                sep = ", ";
            }

            System.out.println();
        }
        if (stackBombCasings.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            String sep = "";
            for (int i = 0; i < stackBombCasings.size(); i++) {
                System.out.print(sep + stackBombCasings.pop());
                sep = ", ";
            }
            System.out.println();
        }
        System.out.printf("Cherry Bombs: %d%n" +
                "Datura Bombs: %d%n" +
                "Smoke Decoy Bombs: %d", cherryBombs, daturaBombs, smokeDecoyBombs);
    }
}
