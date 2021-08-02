import java.util.Scanner;

public class Ex_SwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double recordS = Double.parseDouble(scan.nextLine());
        double meters = Double.parseDouble(scan.nextLine());
        double secOneM = Double.parseDouble(scan.nextLine());
        double zabavqne = Math.floor(meters/15);
        double zabavqneSec = zabavqne*12.5;
        double finalTime = (secOneM * meters) + zabavqneSec;
        double razlika = Math.abs(recordS - finalTime);
        if (finalTime<recordS){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", finalTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", razlika);
        }


    }
}
