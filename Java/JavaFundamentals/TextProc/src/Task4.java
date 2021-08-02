import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] bannedWords = scan.nextLine().split(", ");
        String text = scan.nextLine();
        for (int i = 0; i < bannedWords.length; i++) {
            String replacement = generateReplacement(bannedWords[i].length());
            text = text.replace(bannedWords[i], replacement);
        }
        System.out.println(text);
    }

    private static String generateReplacement(int wordLength) {
        String[] parts = new String[wordLength];
        for (int i = 0; i < wordLength; i++) {
            parts[i] = "*";

        }
        return String.join("", parts);
    }
}
