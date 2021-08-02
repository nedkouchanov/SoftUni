import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int floors = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());
        for (int j = 0; j < rooms; j++) {
            System.out.printf("L%d%d ", floors, j);
        }
        System.out.print("\n");
        for (int i = floors - 1; i > 0; i--) {
            for (int j = 0; j < rooms; j++) {
                if (!(i % 2 == 0)) {
                    System.out.printf("A%d%d ", i, j);
                    if (j == rooms - 1) {
                        System.out.print("\n");
                    }
                }
                if ((i % 2 == 0)) {
                    System.out.printf("O%d%d ", i, j);
                    if (j == rooms - 1) {
                        System.out.print("\n");
                    }
                }
            }
        }
    }
}
