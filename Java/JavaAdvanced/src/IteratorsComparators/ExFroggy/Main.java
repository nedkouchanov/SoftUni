package IteratorsComparators.ExFroggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] stones = Arrays.stream(bf.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Lake lake = new Lake(stones);
        String str = "";
        for (Integer integer : lake) {
            str += integer + ", ";

        }
        System.out.println(str.substring(0, str.length() - 2));
    }
}
