package Generics.CountStr;

import javax.xml.transform.stax.StAXResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Box<String>> boxes = new ArrayList<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            boxes.add(new Box<>(bf.readLine()));
        }
        Box<String> compareWith = new Box<>(bf.readLine());
        System.out.println(genericCount(boxes, compareWith));
    }

    private static int genericCount(List<Box<String>> list, Box<String> target) {
        int count = 0;
        for (Box<String> box : list) {
            if (box.compareTo(target.getData()) > 0) {
                count++;
            }
        }
        return count;
    }
}
