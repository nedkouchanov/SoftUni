import java.util.Arrays;
import java.util.Scanner;

public class Valentine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cupPosition = 0;
        boolean flag = false;
        int cntOhne = 0;
        String[] input = scan.nextLine().split("@");
        int[] house = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
        String jump = scan.nextLine();
        while (!jump.equals("Love!")) {
            String[] tokens = jump.split(" ");
            int length = Integer.parseInt(tokens[1]);
            for (int j = 0; j <= house.length; j++) {
                if (j % house.length == 0) {
                    j = 0;
                }
                if (j == length) {
                    house[j+1] -= 2;
                    cupPosition = j+1;
                    if (house[j] == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", j);
                    }
                    break;
                }
                if (house[j] == 0) {
                    flag = true;
                } else {
                    cntOhne++;
                }
            }
            if (house[cupPosition] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", cupPosition);
            }
            jump = scan.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", cupPosition);
        if (flag) {
            System.out.printf("Mission was successful.%n");
        } else {
            System.out.printf("Cupid has failed %d places.", cntOhne);
        }
    }
}




