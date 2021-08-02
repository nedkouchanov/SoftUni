import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String toRemove = scan.nextLine();
        String word = scan.nextLine();
        while (word.contains(toRemove)) {
            int toRemoveIndex = word.indexOf(toRemove);
            int toRemoveLength = toRemove.length();
            word = word.substring(0, toRemoveIndex) +
                    word.substring(toRemoveIndex + toRemoveLength);
        }
        System.out.println(word);
    }
}
