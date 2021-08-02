import java.util.Scanner;

public class SkiHoliday {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int days = Integer.parseInt(scan.nextLine());
        String room = scan.nextLine();
        String feedback = scan.nextLine();
        int nights = days - 1;
        double cashone = nights * 18.00;
        double apa = nights * 25.00;
        double presiapa = nights * 35.00;
        double discount;
        switch (room) {
            case "room for one person":
                if (feedback.equals("positive")) {
                    System.out.printf("%.2f", cashone + cashone * 0.25);
                    break;
                } else if (feedback.equals("negative")) {
                    System.out.printf("%.2f", cashone - cashone * 0.1);
                    break;
                }
            case "apartment":
                if (days < 10) {
                    discount = apa * 0.7;
                    if (feedback.equals("positive")) {
                        System.out.printf("%.2f", discount + discount * 0.25);
                        break;
                    } else if (feedback.equals("negative")) {
                        System.out.printf("%.2f", discount - discount * 0.1);
                        break;
                    }
                } else if (days >= 10 && days <= 15) {
                    discount = apa * 0.65;
                    if (feedback.equals("positive")) {
                        System.out.printf("%.2f", discount + discount * 0.25);
                        break;
                    } else if (feedback.equals("negative")) {
                        System.out.printf("%.2f", discount - discount * 0.1);
                        break;
                    }
                } else if (days > 15) {
                    discount = apa * 0.5;
                    if (feedback.equals("positive")) {
                        System.out.printf("%.2f", discount + discount * 0.25);
                        break;
                    } else if (feedback.equals("negative")) {
                        System.out.printf("%.2f", discount - discount * 0.1);
                        break;
                    }
                }
            case "president apartment":
                if (days < 10) {
                    discount = apa * 0.9;
                    if (feedback.equals("positive")) {
                        System.out.printf("%.2f", discount + discount * 0.25);
                        break;
                    } else if (feedback.equals("negative")) {
                        System.out.printf("%.2f", discount - discount * 0.1);
                        break;
                    }
                } else if (days >= 10 && days <= 15) {
                    discount = apa * 0.85;
                    if (feedback.equals("positive")) {
                        System.out.printf("%.2f", discount + discount * 0.25);
                        break;
                    } else if (feedback.equals("negative")) {
                        System.out.printf("%.2f", discount - discount * 0.1);
                        break;
                    }
                } else if (days > 15) {
                    discount = presiapa * 0.8;
                    if (feedback.equals("positive")) {
                        System.out.printf("%.2f", discount + discount * 0.25);
                        break;
                    } else if (feedback.equals("negative")) {
                        System.out.printf("%.2f", discount - (discount * 0.1));
                        break;
                    }
                }
        }
    }
}
