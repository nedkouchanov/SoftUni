package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String navigation = scan.nextLine();
        String currentUrl = "";
        while (!navigation.equals("Home")) {
            if (navigation.equals("back")) {
                if (!stack.isEmpty()) {
                    currentUrl = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    navigation = scan.nextLine();
                    continue;
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    stack.push(currentUrl);
                }
                currentUrl = navigation;
            }
            System.out.println(currentUrl);
            navigation = scan.nextLine();
        }
    }
}
