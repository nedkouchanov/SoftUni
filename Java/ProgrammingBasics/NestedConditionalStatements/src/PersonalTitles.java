import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double age = Double.parseDouble(scan.nextLine());
        String title = scan.nextLine();
          if (age >= 16 && title.equals("m")){
              System.out.println("Mr.");
          } else if (age < 16 && title.equals("m")){
              System.out.println("Master");
          } else if (age < 16 && title.equals("f")){
              System.out.println("Miss");
          } else if (age >= 16 && title.equals("f")){
              System.out.println("Ms.");
          }
    }
}
