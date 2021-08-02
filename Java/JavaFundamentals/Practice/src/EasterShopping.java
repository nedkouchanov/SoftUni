import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EasterShopping {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] shopsArr = scan.nextLine().split("\\s+");
        ArrayList<String> shops = new ArrayList<>(Arrays.asList(shopsArr));
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Include": {
                    String shop = tokens[1];
                    shops.add(shop);
                    break;
                }
                case "Visit": {
                    int num = Integer.parseInt(tokens[2]);
                    if (num < shops.size() && num >= 0) {
                        if (tokens[1].equals("first")) {
                            for (int j = 0; j < num; j++) {
                                shops.remove(0);
                            }
                        } else if (tokens[1].equals("last")) {
                            for (int j = 0; j < num; j++) {
                                shops.remove(shops.size() - 1);
                            }
                        }
                    }
                    break;
                }
                case "Prefer": {
                    int shop1ind = Integer.parseInt(tokens[1]);
                    int shop2ind = Integer.parseInt(tokens[2]);
                    if (shop1ind >= 0 && shop1ind < shops.size() && shop2ind >= 0 && shop2ind < shops.size()) {
                        String shop1 = shops.get(shop1ind);
                        String shop2 = shops.get(shop2ind);
                        shops.set(shop1ind, shop2);
                        shops.set(shop2ind, shop1);
                    }
                    break;
                }
                case "Place": {
                    String shop = tokens[1];
                    int shopInd = Integer.parseInt(tokens[2]);
                    if (shopInd >= 0 && shopInd < shops.size()) {
                        if (shopInd + 1 < shops.size()) {
                            shops.add(shopInd + 1, shop);
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("Shops left:");
        for (String shop : shops) {
            System.out.print(shop + " ");

        }
    }
}
