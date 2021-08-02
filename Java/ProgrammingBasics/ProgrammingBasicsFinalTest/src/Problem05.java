import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int guest = Integer.parseInt(scan.nextLine());
        int presents = Integer.parseInt(scan.nextLine());
        String category = scan.nextLine();
        int moneyCnt = 0;
        int elCnt = 0;
        int vauCnt = 0;
        int otherCnt = 0;
        int cnt = 0;
        while (presents > cnt) {
            switch (category) {
                case "A":
                    moneyCnt++;
                    cnt++;
                    break;
                case "B":
                    elCnt++;
                    cnt++;
                    break;
                case "V":
                    vauCnt++;
                    cnt++;
                    break;
                case "G":
                    otherCnt++;
                    cnt++;
                    break;
            }
            if (presents <= cnt) {
                break;
            }
            category = scan.nextLine();
        }
        double moneyPer = ((double) moneyCnt / presents) * 100;
        double elPer = ((double) elCnt / presents) * 100;
        double vauPer = ((double) vauCnt / presents) * 100;
        double otherPer = ((double) otherCnt / presents) * 100;
        double presPer = ((double) presents / guest) * 100;
        System.out.printf("%.2f%%%n", moneyPer);
        System.out.printf("%.2f%%%n", elPer);
        System.out.printf("%.2f%%%n", vauPer);
        System.out.printf("%.2f%%%n", otherPer);
        System.out.printf("%.2f%%%n", presPer);
    }
}
