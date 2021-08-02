import java.util.Scanner;

public class BetweenAscii {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char start = scan.next().charAt(0);
        char finish = scan.next().charAt(0);

        between(start, finish);

    }

    private static void between(char start, char finish) {
        int startInt = (int) start;
        int finishInt = (int) finish;
        if(startInt<finishInt){
        for (int i = startInt + 1; i < finishInt; i++) {
            char newCh = (char) i;
            System.out.print(newCh + " ");
        }
        } else {
            for (int i = finishInt+1; i < startInt; i++) {
                char newCh = (char) i;
                System.out.print(newCh + " ");
            }
        }
    }
}
