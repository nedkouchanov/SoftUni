import java.util.Scanner;

public class Ex_Cinema {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String proj = scan.nextLine();
        int rows= Integer.parseInt(scan.nextLine());
        int columns= Integer.parseInt(scan.nextLine());
        double prihod = 0.0;
        if (proj.equals("Premiere")){
            prihod = rows*columns*12;
        } else if (proj.equals("Normal")){
            prihod = rows*columns*7.5;
        } else if(proj.equals("Discount")){
            prihod = rows*columns*5;
        }
        System.out.printf("%.2f", prihod);
    }
}
