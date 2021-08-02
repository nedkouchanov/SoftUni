package DefClasses.Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Person> people = new ArrayList<>();
        while (!(line = bf.readLine()).equals("End")) {
            String[] tokens = line.split("\\s+");
            Person person = new Person(tokens[0]);
            boolean hasPerson = false;
            for (Person currPerson : people) {
                if (currPerson.getName().equals(tokens[0])) {
                    hasPerson = true;
                    person = currPerson;
                    break;
                }
            }
            switch (tokens[1]) {
                case "company":
                    Company company = new Company(tokens[2],
                            tokens[3], Double.parseDouble(tokens[4]));
                    person.setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    List<Pokemon> pokemons = person.getPokemons();
                    pokemons.add(pokemon);
                    person.setPokemons(pokemons);
                    break;
                case "parents":
                    Parent parent = new Parent(tokens[2], tokens[3]);
                    List<Parent> parents = person.getParents();
                    parents.add(parent);
                    person.setParents(parents);
                    break;
                case "children":
                    Child child = new Child(tokens[2], tokens[3]);
                    List<Child> children = person.getChildren();
                    children.add(child);
                    person.setChildren(children);
                    break;
                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    person.setCar(car);
                    break;
            }

            if (!hasPerson) {
                people.add(person);
            }
        }
        String targetName = bf.readLine();
        for (Person person : people) {
            if (person.getName().equals(targetName)) {
                StringBuilder sb = new StringBuilder();
                sb.append(person.getName()).append(System.lineSeparator());
                sb.append("Company:").append(System.lineSeparator());
                if (person.getCompany() != null) {
                    sb.append(person.getCompany().toString()).append(System.lineSeparator());
                }
                sb.append("InterfacesAndAbstraction.CarShop.InterfacesAndAbstraction.car.Polymorphism.vehicle.Car:").append(System.lineSeparator());
                if (person.getCar() != null) {
                    sb.append(person.getCar().toString()).append(System.lineSeparator());
                }
                sb.append("Pokemon:").append(System.lineSeparator());
                for (Pokemon pokemon : person.getPokemons()) {
                    sb.append(pokemon.toString()).append(System.lineSeparator());
                }
                sb.append("Parents:").append(System.lineSeparator());
                for (Parent parent : person.getParents()) {
                    sb.append(parent.toString()).append(System.lineSeparator());
                }
                sb.append("Children:").append(System.lineSeparator());
                for (Child child : person.getChildren()) {
                    sb.append(child.toString()).append(System.lineSeparator());
                }
                System.out.println(sb.toString());
                break;
            }
        }
    }
}
