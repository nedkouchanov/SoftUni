package SetAndMap;

import com.sun.source.tree.Tree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static javax.swing.UIManager.put;

public class Ex_UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = "";
        TreeMap<String, LinkedHashMap<String, Integer>> usersLogs = new TreeMap<>();
        while (!(line = scan.nextLine()).equals("end")) {
            String[] tokens = line.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];
            if (!(usersLogs.containsKey(username))) {
                usersLogs.put(username, new LinkedHashMap<>() {{
                    put(ip, 1);
                }});
            } else {
                if (usersLogs.get(username).containsKey(ip)) {
                    int count = usersLogs.get(username).get(ip) + 1;
                    usersLogs.get(username).put(ip, count);
                } else {
                    usersLogs.get(username).put(ip, 1);
                }
            }

        }
        usersLogs.forEach((key, value) -> {
            System.out.println(key + ":");
            StringBuilder sb = new StringBuilder();
            value.forEach((innerKey, innerValue) -> {
                sb.append(String.format("%s => %d, ", innerKey, innerValue));
            });
            System.out.println((sb.substring(0, sb.length() - 2) + "."));
        });
    }
}
