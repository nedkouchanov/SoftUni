package SetAndMap;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String guest = scan.nextLine();
        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();
        while (!guest.equals("PARTY")) {
            char firstChar = guest.charAt(0);
            if (Character.isDigit(firstChar)) {
                vip.add(guest);
            } else {
                regular.add(guest);
            }
            guest = scan.nextLine();
        }
        guest = scan.nextLine();
        while (!guest.equals("END")) {
            vip.remove(guest);
            regular.remove(guest);
            guest = scan.nextLine();
        }
        System.out.println(vip.size()+regular.size());
        for (String s : vip) {
            System.out.println(s);
        }
        for (String s : regular) {
            System.out.println(s);
        }
    }
}
