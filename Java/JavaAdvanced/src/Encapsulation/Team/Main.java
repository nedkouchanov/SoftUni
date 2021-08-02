package Encapsulation.Team;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Team> teams = new ArrayList<>();
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] inputArgs = input.split(";");
            switch (inputArgs[0]) {
                case "Encapsulation.Team.Team":
                    Team team = new Team(inputArgs[1]);
                    teams.add(team);
                    break;
                case "Add":
                    String teamName = inputArgs[1];
                    String playerName = inputArgs[2];
                    int end = Integer.parseInt(inputArgs[3]);
                    int spr = Integer.parseInt(inputArgs[4]);
                    int drb = Integer.parseInt(inputArgs[5]);
                    int pass = Integer.parseInt(inputArgs[6]);
                    int shoot = Integer.parseInt(inputArgs[7]);
                    boolean added = false;

                    Player player = new Player(playerName, end, spr, drb, pass, shoot);
                    players.add(player);
                    for (Team team1 : teams) {
                        if (team1.getName().equals(teamName)) {
                            added = true;
                            team1.addPlayer(player);
                        }
                    }
                    if (!added) {
                        System.out.println("Encapsulation.Team.Team " + teamName + " does not exist.");
                    }
                    break;
                case "Remove":
                    String teamName1 = inputArgs[1];
                    String playerToRemoveName = inputArgs[2];
                    Player currPlayer = null;
                    for (Player player1 : players) {
                        if (player1.getName().equals(playerToRemoveName)) {
                            currPlayer = player1;
                        }
                    }
                    if (currPlayer == null) {
                        System.out.println("Encapsulation.Team.Player " + playerToRemoveName + " is not in " + teamName1 + " team.");
                        break;
                    }
                    for (Team team1 : teams) {
                        if (team1.getName().equals(teamName1)) {
                            team1.removePlayer(currPlayer);
                        }
                    }
                    break;
                case "Rating":
                    String teamName2 = inputArgs[1];
                    boolean exist = false;
                    for (Team team1 : teams) {
                        if (team1.getName().equals(teamName2)) {
                            team1.getRating();
                            System.out.println(team1.getName() + " - " + team1.getRating());
                            exist = true;
                        }
                    }
                    if (!exist) {
                        System.out.println("Encapsulation.Team.Team " + teamName2 + " does not exist.");
                    }
                    break;
                default:
                    break;

            }
            input = scanner.nextLine();
        }
    }
}
