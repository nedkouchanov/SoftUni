import java.util.Scanner;

public class Enrcypt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] current = scan.nextLine().split("");
            for (int j = 0; j < current.length; j++) {
               String asd = current[j];
               int numericValue = Integer.valueOf(asd);
                int vowelSum = 0;
                int consSum = 0;
                switch (j) {
                    case 65:
                    case 69:
                    case 73:
                    case 79:
                    case 85:
                    case 97:
                    case 101:
                    case 105:
                    case 111:
                    case 117:
                        vowelSum += current[j].charAt(j);
                        break;
                    default:
                        consSum += current[j].charAt(j);
                }
            }
        }
    }
}
