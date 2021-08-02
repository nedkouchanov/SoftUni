import java.util.Scanner;

public class Ex_Scholarship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double dohod = Double.parseDouble(scan.nextLine());
        double ocenka = Double.parseDouble(scan.nextLine());
        double minZaplata = Double.parseDouble(scan.nextLine());
        double socStipendia = Math.floor(minZaplata * 0.35);
        double Stipendia =Math.floor( ocenka * 25);
        if (dohod <= minZaplata && ocenka >= 4.5 && ocenka < 5.5) {
            System.out.printf("You get a Social scholarship %.0f BGN", socStipendia);
        } else if (ocenka >= 5.5 && Stipendia >= socStipendia) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN", Stipendia);
        } else if (ocenka >= 5.5 && Stipendia < socStipendia) {
            System.out.printf("You get a Social scholarship %.0f BGN", socStipendia);
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}
