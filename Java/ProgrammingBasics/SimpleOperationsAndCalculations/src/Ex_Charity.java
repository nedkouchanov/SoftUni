import java.util.Scanner;

public class Ex_Charity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        int sladkari = Integer.parseInt(scan.nextLine());
        int torti = Integer.parseInt(scan.nextLine());
        int gofreti = Integer.parseInt(scan.nextLine());
        int panc = Integer.parseInt(scan.nextLine());
        double tortiFinal = torti*45;
        double gofretiFinal= gofreti*5.80;
        double pancFinal= panc*3.20;
        double sum = (tortiFinal+gofretiFinal+pancFinal)*sladkari;
        double whole = sum*days;
        double finals = whole - (0.125*whole);


        System.out.printf("%.2f", finals);
    }
}
