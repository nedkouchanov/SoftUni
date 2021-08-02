package StacksAndQueues;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex_Parent {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("");
        ArrayList<String> braces = new ArrayList<>(Arrays.asList(input));
        if (braces.size() % 2 != 0) {
            System.out.println("NO");
            return;
        }
        ArrayDeque<String> openBraces = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < braces.size(); i++) {
            if (braces.get(i).equals("(") || braces.get(i).equals("{") || braces.get(i).equals("[")) {
                openBraces.push(braces.get(i));
            } else {
                String currentBrace = openBraces.pop();
                if (braces.get(i).equals("}")) {
                    braces.set(i, "{");
                }
                if (braces.get(i).equals(")")) {
                    braces.set(i, "(");
                }
                if (braces.get(i).equals("]")) {
                    braces.set(i, "[");
                }
                if (!braces.get(i).equals(currentBrace)) {
                    System.out.println("NO");
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        }
    }
}
