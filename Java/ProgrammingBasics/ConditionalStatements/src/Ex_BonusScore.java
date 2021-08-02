import java.util.Scanner;

public class Ex_BonusScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = Integer.parseInt(scan.nextLine());
        double bonus = 0;
        if(score <=100){
            bonus=5;
        } else if (score > 100 && score < 1000){
            bonus=score*0.2;
        } else {
            bonus = score*0.1;
        }
        if(score % 2==0){
            bonus=bonus+1;
        }else if(score %10==5 ){
            bonus=bonus+2;
        }
        double finalScore = score+bonus;
        System.out.println(bonus);
        System.out.println(finalScore);
    }
}
