import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tasks {
    public static void main(String[] args) {
        int completeCnt = 0;
        int incompleteCnt = 0;
        int droppedCnt = 0;
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        List<String> tasks = new ArrayList<>(Arrays.asList(input));
        String inputs = scan.nextLine();
        while (!inputs.equals("End")) {
            String[] tokens = inputs.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Complete": {
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < tasks.size()) {
                        tasks.set(index, "0");
                    }
                    break;
                }
                case "Change": {
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < tasks.size()) {
                        String time = tokens[2];
                        tasks.set(index, time);
                        break;
                    }
                }
                case "Drop": {
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < tasks.size()) {
                        tasks.set(index, "-1");
                    }
                    break;
                }
                case "Count": {
                    if ("Completed".equals(tokens[1])) {
                        for (String task : tasks) {
                            if ("0".equals(task)) {
                                completeCnt++;
                            }
                        }
                        System.out.println(completeCnt);
                        break;
                    } else if ("Incomplete".equals(tokens[1])) {
                        for (String task : tasks) {
                            if (!"0".equals(task) && !"-1".equals(task)) {
                                incompleteCnt++;
                            }
                        }
                        System.out.println(incompleteCnt);
                        break;
                    } else if ("Dropped".equals(tokens[1])) {
                        for (String task : tasks) {
                            if ("-1".equals(task)) {
                                droppedCnt++;
                            }
                        }
                        System.out.println(droppedCnt);
                        break;
                    }
                }
            }
            inputs = scan.nextLine();
        }
        for (String task : tasks) {
            if (!"0".equals(task) && !"-1".equals(task)) {
                System.out.print(task + " ");
            }
        }
    }
}
