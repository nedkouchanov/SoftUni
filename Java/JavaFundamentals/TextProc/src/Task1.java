import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        while (!word.equals("end")) {
            String reversed = reverse(word);
            System.out.println(word + " = " + reversed);
            word = scan.nextLine();
        }
    }


    private static String reverse(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        return result;
    }

}
