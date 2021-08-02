package Generics.ExTuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            switch (i) {
                case 0:
                    String fullName = tokens[0] + " " + tokens[1];
                    Tuple<String, String> tuple = new Tuple<>(fullName, tokens[2]);
                    System.out.println(tuple);
                    break;
                case 1:
                    Tuple<String,Integer> tuple1 = new Tuple<>(tokens[0],Integer.parseInt(tokens[1]));
                    System.out.println(tuple1);
                    break;
                case 2:
                    Tuple<Integer,Double> tuple2=new Tuple<>(Integer.parseInt(tokens[0]),Double.parseDouble(tokens[1]));
                    System.out.println(tuple2);
                    break;
            }
        }
    }
}
