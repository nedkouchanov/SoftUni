package Encapsulation.Team;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<Player>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("A name should not be empty.");
        } else
            this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        if (this.players.contains(player)) {
            this.players.remove(player);
        } else {
            System.out.println(String.format
                    ("Encapsulation.Team.Player %s is not in %s team.", player, this.name));
        }
    }

    public double getRating() {
        return Math.round((players.stream().mapToDouble
                (Player::overallSkillLevel).sum()) / players.size());
    }
}
