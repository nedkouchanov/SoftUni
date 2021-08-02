import java.util.Scanner;

public class Ex_OnTimeExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int examH = Integer.parseInt(scan.nextLine());
        int examM = Integer.parseInt(scan.nextLine());
        int obshtoexam = examH * 59 + examM;
        int arriveH = Integer.parseInt(scan.nextLine());
        int arriveM = Integer.parseInt(scan.nextLine());
        int obshtoarrive = arriveH * 59 + arriveM;
        int abs = obshtoexam - obshtoarrive;
        if (examH == arriveH && examM == arriveM) {
            System.out.println("On Time");
        } else if (obshtoexam - obshtoarrive < 30 && obshtoexam - obshtoarrive > 0) {
            System.out.println("On Time");
        } else if (obshtoarrive > obshtoexam) {
            System.out.println("Late");
        } else if (obshtoexam - obshtoarrive > 30) {
            System.out.println("Early");
        }
        if (examH != arriveH && examM != arriveM) {
            if (abs >= 1 && abs <= 59) {
                System.out.printf("%d minutes before the start", abs + 1);
            } else if (abs >= -59 && abs <= -1) {
                System.out.printf("%d minutes after the start", Math.abs(abs));
            } else if(abs > 1 && abs > 59){
                System.out.printf("%d:%d hours before the start", examH-arriveH,examM-arriveM );
            } else if(abs<-1&&abs<-59){
                System.out.printf("%d:%d hours after the start", arriveH-examH,arriveM-examM );
            }
        }
    }
}
