import java.util.Scanner;

public class Ex_Volleyball {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String visg = scan.nextLine();
        int pr = Integer.parseInt(scan.nextLine());
        int holi = Integer.parseInt(scan.nextLine());
        int weekendsSofia = 48 - holi;
        double playsSf = weekendsSofia * (3.0 / 4);
        double playsPr = pr * (2.0 / 3);
        double sum = playsPr + holi + playsSf;
        int result;
        if (visg.equals("leap")) {
            sum = sum + (sum * 0.15);
            result = (int) (Math.floor(sum));
            System.out.println(result);
        } else if (visg.equals("normal")) {
            result = (int) (Math.floor(sum));
            System.out.println(result);
        }
    }
}
