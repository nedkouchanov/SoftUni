import java.util.Scanner;

public class NameWars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        String bestName = "";
        int bestNameSum = 0;
        while (!"STOP".equals(name)) {
            int currentNameSum = 0;
            for (int i = 0; i < name.length(); i++) {
                currentNameSum += name.charAt(i);
            }
            if(currentNameSum>bestNameSum){
                bestNameSum=currentNameSum;
                bestName=name;
            }
            name = scan.nextLine();
        }
        System.out.printf("Winner is %s - %d!", bestName,bestNameSum);
    }
}
