package Generics.ExGenericSwap;

import Generics.ExGenericBox.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Box<Integer>> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(new Box<Integer>(Integer.parseInt(bf.readLine())));
        }
        int[] indexes = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        swapElements(boxes,indexes[0],indexes[1]);
        for (Box<Integer> box : boxes) {
            System.out.println(box);
        }
    }

    public static <E> void swapElements(List<E> list, int firstIndex, int secondIndex) {
        E firstElement = list.get(firstIndex);
        E secondElement = list.get(secondIndex);
        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);
    }
}
