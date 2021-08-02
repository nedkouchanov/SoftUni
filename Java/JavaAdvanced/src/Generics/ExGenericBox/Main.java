package Generics.ExGenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            Box<Integer> box = new Box<>(Integer.parseInt(bf.readLine()));
            System.out.println(box);
        }
    }
}
