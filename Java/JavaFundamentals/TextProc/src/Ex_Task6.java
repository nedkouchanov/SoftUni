import java.util.Scanner;

public class Ex_Task6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder result = new StringBuilder();
        char baseLetter = input.charAt(0);
        result.append(baseLetter);
        for (int i = 1; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            if (baseLetter != currentLetter) {
                result.append(baseLetter);
                baseLetter = currentLetter;
            }
        }
        System.out.println(result);
    }
}
