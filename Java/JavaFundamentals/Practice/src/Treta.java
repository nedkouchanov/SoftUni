import java.util.Arrays;
import java.util.Scanner;

public class Treta {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        int cntOhne = 0;
        int cupPosition = 0;
        String[] input = scan.nextLine().split("@");
        int[] house = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        String jump = scan.nextLine();
        int i = 0;
        while (!jump.equals("Love!")) {
            String[] tokens = jump.split(" ");
            int length = Integer.parseInt(tokens[1]);
            for (i = cupPosition; i <= house.length; i++) {
                if (i == house.length) {
                    i = 0;
                }
                if (i == length) {
                    house[cupPosition] -= 2;
                    if (house[i] <= 0) {
                        System.out.printf("Place %d has Valentine's day.%n", i);
                    }
                    break;
                }
                if (house[i] == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", i);
                }
                if (house[i] == 0) {
                    flag = true;
                } else {
                    cntOhne++;
                }
            }
            jump = scan.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", i);
        if (flag) {
            System.out.printf("Mission was successful.%n");
        } else {
            System.out.printf("Cupid has failed %d places.", cntOhne);
        }
    }
}

