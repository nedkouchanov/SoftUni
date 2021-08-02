import java.util.Scanner;

public class TradeComm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String town = scan.nextLine();
        double prodaj = Double.parseDouble(scan.nextLine());
        if (town.equals("Sofia") || town.equals("Varna") || town.equals("Plovdiv")) {
            if (prodaj > 0) {
                switch (town) {
                    case "Sofia":
                        if (prodaj >= 0 && prodaj <= 500) {
                            System.out.printf("%.2f", prodaj * 0.05);
                            break;
                        } else if (prodaj > 500 && prodaj <= 1000) {
                            System.out.printf("%.2f", prodaj * 0.07);
                            break;
                        } else if (prodaj > 1000 && prodaj <= 10000) {
                            System.out.printf("%.2f", prodaj * 0.08);
                            break;
                        } else if (prodaj > 10000) {
                            System.out.printf("%.2f", prodaj * 0.12);
                            break;
                        }
                    case "Varna":
                        if (prodaj >= 0 && prodaj <= 500) {
                            System.out.printf("%.2f", prodaj * 0.045);
                            break;
                        } else if (prodaj > 500 && prodaj <= 1000) {
                            System.out.printf("%.2f", prodaj * 0.075);
                            break;
                        } else if (prodaj > 1000 && prodaj <= 10000) {
                            System.out.printf("%.2f", prodaj * 0.1);
                            break;
                        } else if (prodaj > 10000) {
                            System.out.printf("%.2f", prodaj * 0.13);
                            break;
                        }
                    case "Plovdiv":
                        if (prodaj >= 0 && prodaj <= 500) {
                            System.out.printf("%.2f", prodaj * 0.055);
                            break;
                        } else if (prodaj > 500 && prodaj <= 1000) {
                            System.out.printf("%.2f", prodaj * 0.08);
                            break;
                        } else if (prodaj > 1000 && prodaj <= 10000) {
                            System.out.printf("%.2f", prodaj * 0.12);
                            break;
                        } else if (prodaj > 10000) {
                            System.out.printf("%.2f", prodaj * 0.145);
                            break;
                        }
                }
            } else {
                System.out.println("error");
            }
        } else {
            System.out.println("error");
        }
    }
}
