import java.util.Scanner;

public class Vending {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        double sum = 0;
        boolean dve = true;
        boolean flag = true;
        while (!input.equals("Start")) {
            double moneyIns = Double.parseDouble(input);
            if (moneyIns != 0.1 && moneyIns != 0.2 && moneyIns != 0.5
                    && moneyIns != 1 && moneyIns != 2) {
                System.out.printf("Cannot accept %.2f%n", moneyIns);
                input = scan.nextLine();
            } else {
                sum += moneyIns;
                input = scan.nextLine();
            }
        }
        String option = scan.nextLine();
        while (!option.equals("End")) {
            if(flag) {
                switch (option) {
                    case "Nuts":
                        if(sum>2) {
                            sum -= 2.0;
                        } else{
                            dve = false;
                        }
                        break;
                    case "Water":
                        if(sum>0.7) {
                            sum -= 0.7;
                        } else{
                            dve = false;
                        }
                        break;
                    case "Crisps":
                        if(sum>1.5){
                        sum -= 1.5;
                        } else{
                            dve = false;
                        }
                        break;
                    case "Soda":
                        if(sum>0.8){
                        sum -= 0.8;
                        } else{
                            dve = false;
                        }
                        break;
                    case "Coke":
                        if(sum>1) {
                            sum -= 1;
                        } else{
                            dve = false;
                        }
                        break;
                    default:
                        System.out.println("Invalid product");
                        dve=false;
                }
                if (!dve) {
                    System.out.println("Sorry, not enough money");
                    flag = false;
                } else {
                    System.out.printf("Purchased %s%n", option);
            }
                option = scan.nextLine();
            }
        }
        System.out.printf("Change: %.2f", sum);

    }
}

