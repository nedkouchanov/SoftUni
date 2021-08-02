package Articles;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Article> articles = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Article article = new Article(title, content, author);
            articles.add(article);
        }
        String command = scan.nextLine();
        printResult(command, articles);
    }

    public static void printResult(String command, ArrayList<Article> articles) {
        switch (command) {
            case "title":
                articles
                        .stream()
                        .sorted((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()))
                        .forEach(a -> System.out.println(a.toString()));
                break;
            case "content":
                articles
                        .stream()
                        .sorted((a1, a2) -> a1.getContent().compareTo(a2.getContent()))
                        .forEach(a -> System.out.println(a.toString()));
                break;
            case "author":
                articles
                        .stream()
                        .sorted((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor()))
                        .forEach(a -> System.out.println(a.toString()));
                break;
        }

    }
}
