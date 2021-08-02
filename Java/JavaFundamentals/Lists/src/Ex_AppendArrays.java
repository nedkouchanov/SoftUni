import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex_AppendArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\|");
        ArrayList<String> result = new ArrayList<>();
        for (int i = input.length - 1; i >= 0; i--) {
            String[] arr = input[i].trim().split("\\s+");
            for (String element : arr) {
                result.add(element);
            }
            result.remove("");
        }
        System.out.println(String.join(" ", result));
    }
}
