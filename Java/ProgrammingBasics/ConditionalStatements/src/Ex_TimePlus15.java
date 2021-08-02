import java.util.Scanner;

public class Ex_TimePlus15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hours = Integer.parseInt(scan.nextLine());
        int minutes = Integer.parseInt(scan.nextLine());
        int evrythingMin = minutes + (hours * 60);
        int nextfift = evrythingMin + 15;
        int hoursFinal = nextfift / 60;
        int minutesFinal = nextfift % 60;
        if (hoursFinal > 23) {
            hoursFinal = 0;
        }

        if (hours >= 0 && hours <= 23) {
            if (minutes >= 0 && minutes <= 59) {
                if (minutesFinal < 10) {
                    System.out.printf("%d:0%d", hoursFinal, minutesFinal);
                } else {
                    System.out.printf("%d:%d", hoursFinal, minutesFinal);

                }
            }
        }
    }
}
