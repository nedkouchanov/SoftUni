package IteratorsComparators.ExListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        ListIterator listIterator=null;
        while (!(line = bf.readLine()).equals("END")) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    listIterator = new ListIterator(Arrays.stream(tokens)
                            .skip(1).toArray(String[]::new));
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    listIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());;
                    break;
                case "PrintAll":
                    listIterator.printAll();
                    break;
            }
        }
    }
}
