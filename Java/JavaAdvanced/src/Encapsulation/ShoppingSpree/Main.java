package Encapsulation.ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleInput = bf.readLine().split(";");
        Map<String, Person> people = new LinkedHashMap<>();
        for (String in : peopleInput) {
            String[] tokens = in.split("=");
            people.putIfAbsent(tokens[0], new Person(tokens[0], Double.parseDouble(tokens[1])));
        }
        String[] productsInput = bf.readLine().split(";");
        Map<String, Product> products = new LinkedHashMap<>();
        for (String in : productsInput) {
            String[] tokens = in.split("=");
            products.putIfAbsent(tokens[0], new Product(tokens[0], Double.parseDouble(tokens[1])));
        }
        String line;
        while (!(line = bf.readLine()).equals("END")) {
            String[] tokens = line.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            if (people.containsKey(personName) && products.containsKey(productName)) {
                Person person = people.get(personName);
                Product product = products.get(productName);
                person.buyProduct(product);
            }
        }
        for (Person person : people.values()) {
            System.out.println(person);
        }
    }
}
