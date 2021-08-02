package SetAndMap;

import java.util.*;

public class Ex_LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        TreeMap<String, Integer> durations = new TreeMap<>();
        HashMap<String, TreeSet<String>> ips = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String ip = tokens[0];
            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);
            if (!(ips.containsKey(name))) {
                durations.put(name, duration);
                ips.put(name, new TreeSet<>() {{
                    add(ip);
                }});
            } else {
                Set<String> set = ips.get(name);
                if (set.contains(ip)) {
                    int updateDuration = durations.get(name) + duration;
                    durations.put(name, updateDuration);
                } else {
                    ips.get(name).add(ip);
                    int updateDuraion = durations.get(name) + duration;
                    durations.put(name, updateDuraion);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : durations.entrySet()) {
            String userName = entry.getKey();
            System.out.printf("%s: %d [%s]\n", userName, entry.getValue(),
                    String.join(", ", ips.get(userName)));
        }
    }
}