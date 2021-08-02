package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int num = Integer.parseInt(scan.nextLine());
        if(num==0){
            System.out.println("0");
            return;
        }
        while (num != 0) {
            stack.push(num % 2);
            num /= 2;
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
