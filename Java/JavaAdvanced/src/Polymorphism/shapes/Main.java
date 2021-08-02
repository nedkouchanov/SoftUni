package Polymorphism.shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Shape first = new Circle(12D);
        Shape second = new Rectangle(10D, 5D);
        System.out.println(first.calculateArea());
        System.out.println(first.calculatePerimeter());
        System.out.println(second.calculateArea());
        System.out.println(second.calculatePerimeter());

    }
}
