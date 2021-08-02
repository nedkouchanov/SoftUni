import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int standardCNT = 0;
        int studentCNT = 0;
        int kidCNT = 0;
        while (!"Finish".equals(name)) {
            int capacity = Integer.parseInt(scan.nextLine());
            int placeTaken = 0;
            for (int places = 0; places < capacity; places++) {
                String type = scan.nextLine();
                if ("End".equals(type)) {
                    break;
                }
                placeTaken++;
                switch (type) {
                    case "standard":
                        standardCNT++;
                        break;
                    case "student":
                        studentCNT++;
                        break;
                    case "kid":
                        kidCNT++;
                        break;
                }
            }
            System.out.printf("%s - %.2f%% full.%n", name, placeTaken * 1.0 / capacity * 100);
            name = scan.nextLine();
        }
        int totalTickets = studentCNT + standardCNT + kidCNT;
        System.out.println("Total tickets: " + totalTickets);
        System.out.printf("%.2f%% student tickets.%n", studentCNT * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", standardCNT * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% kids tickets.%n", kidCNT * 1.0 / totalTickets * 100);
    }
}
