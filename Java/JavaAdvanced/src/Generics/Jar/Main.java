package Generics.Jar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Jar<String> jarStack = new Jar<>();
        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            jarStack.add(input[i]);
        }
        System.out.printf("The guest is %s %s (%s years old)", jarStack.remove(), jarStack.remove(), jarStack.remove());
    }
}
