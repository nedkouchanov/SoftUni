import java.util.Scanner;

public class Beer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        double bestVolume = -1;
        String bestKeg = "";
        for (int i = 0; i < n; i++) {
            String type = scan.nextLine();
            double radius = Double.parseDouble(scan.nextLine());
            int height = Integer.parseInt(scan.nextLine());
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > bestVolume) {
                bestVolume = volume;
                bestKeg = type;
            }
        }
        System.out.println(bestKeg);
    }

}
