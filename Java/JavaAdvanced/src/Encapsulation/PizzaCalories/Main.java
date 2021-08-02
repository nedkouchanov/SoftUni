package Encapsulation.PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] pizzaInput = bf.readLine().split("\\s+");
        String pizzaName = pizzaInput[1];
        int toppingsNumber = Integer.parseInt(pizzaInput[2]);
        Pizza pizza = new Pizza(pizzaName, toppingsNumber);
        String[] doughInput = bf.readLine().split("\\s+");
        String doughType = doughInput[1];
        String doughTechnique = doughInput[2];
        int doughWeight = Integer.parseInt(doughInput[3]);
        Dough dough = new Dough(doughType, doughTechnique, doughWeight);
        pizza.setDough(dough);
        String line;
        while (!(line = bf.readLine()).equals("END")) {
            String[] tokens = line.split("\\s+");
            String toppingName = tokens[1];
            int toppingWeight = Integer.parseInt(tokens[2]);
            Topping topping = new Topping(toppingName, toppingWeight);
            pizza.addTopping(topping);
        }
        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
