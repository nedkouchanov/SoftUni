package DefClasses.BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static class BankAccount {
        private static int idCounter = 1;
        private int id;
        private double balance;
        private static double interestRate = 0.02;

        public BankAccount() {
            this.id = idCounter;
            idCounter++;
            System.out.println("Account ID" + this.id + " created");
        }

        public static void setInterestRate(double interest) {
            interestRate = interest;
        }

        public double getInterest(int years) {
            return (this.balance * this.interestRate) * years;
        }

        public int getId() {
            return this.id;
        }

        public void deposit(double amount) {
            this.balance += amount;
            System.out.println("Deposited " + (int) amount + " to ID" + this.id);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                bankAccounts.put(bankAccount.getId(), bankAccount);
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccounts.containsKey(id)) {
                    BankAccount bankAccount = bankAccounts.get(id);
                    bankAccount.deposit(Double.parseDouble(tokens[2]));
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.equals("SetInterest")) {
                double newInterest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(newInterest);
            } else {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccounts.containsKey(id)) {
                    BankAccount bankAccount = bankAccounts.get(id);
                    System.out.printf("%.2f%n", bankAccount.getInterest
                            (Integer.parseInt(tokens[2])));
                } else {
                    System.out.println("Account does not exist");

                }
            }
            input = scan.nextLine();

        }
    }
}