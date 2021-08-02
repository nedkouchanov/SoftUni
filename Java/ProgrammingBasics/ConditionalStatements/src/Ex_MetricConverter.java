import java.util.Scanner;

public class Ex_MetricConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double num = Double.parseDouble(scan.nextLine());
        String start = scan.nextLine();
        String finals = scan.nextLine();
        double result;
        if (start.equals("mm")){
            num = num/1000;
        }else if (start.equals("cm")){
            num = num/100;
        }
        if (finals.equals("mm")){
            result = num*1000;
            System.out.printf("%.3f",result);
        } else if (finals.equals("cm")){
            result = num*100;
            System.out.printf("%.3f",result);
        } else {
            result=num;
            System.out.printf("%.3f",result);
        }


    }
}
