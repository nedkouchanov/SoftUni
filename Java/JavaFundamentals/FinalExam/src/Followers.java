import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> followersLikes = new HashMap<>();
        HashMap<String, Integer> followersComments = new HashMap<>();

        String input = scan.nextLine();
        while (!"Log out".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String username = tokens[1];
            switch (command) {
                case "New follower":
                    followersLikes.putIfAbsent(username, 0);
                    followersComments.putIfAbsent(username, 0);
                    break;
                case "Like":
                    Integer currentLikes = followersLikes.get(username);
                    int newLikes = Integer.parseInt(tokens[2]);
                    if (currentLikes != null) {
                        followersLikes.put(username, currentLikes + newLikes);
                    } else {
                        followersLikes.put(username, newLikes);
                        followersComments.put(username, 0);
                    }
                    break;
                case "Comment":
                    Integer currentComments = followersComments.get(username);
                    if (currentComments != null) {
                        followersComments.put(username, currentComments + 1);
                    } else {
                        followersComments.put(username, 1);
                        followersLikes.put(username, 0);
                    }
                    break;
                case "Blocked":
                    if (followersComments.containsKey(username)) {
                        followersComments.remove(username);
                        followersLikes.remove(username);
                    } else {
                        System.out.println(String.format("%s doesn't exist.", username));
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.format("%d followers", followersLikes.size()));
        followersLikes
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    String name = entry.getKey();
                    int like = entry.getValue();
                    int comment = followersComments.get(name);
                    int sum = like + comment;
                    System.out.println(String.format("%s: %d", name, sum));
                });
    }
}
