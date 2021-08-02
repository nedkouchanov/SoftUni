package Encapsulation.Team;

import java.util.ArrayList;

public class Player extends ArrayList<Player> {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("A name should not be empty.");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    private void setEndurance(int endurance) {
        if (skillIsValid(endurance)) {
            this.endurance = endurance;
        } else {
            System.out.println("Endurance should be between 0 and 100.");
        }
    }

    private void setSprint(int sprint) {
        if (skillIsValid(sprint)) {
            this.sprint = sprint;
        } else {
            System.out.println("Sprint should be between 0 and 100.");
        }
    }

    private void setDribble(int dribble) {
        if (skillIsValid(dribble)) {
            this.dribble = dribble;
        } else {
            System.out.println("Dribble should be between 0 and 100.");
        }
    }

    private void setPassing(int passing) {
        if (skillIsValid(passing)) {
            this.passing = passing;
        } else {
            System.out.println("Passing should be between 0 and 100.");
        }
    }

    private void setShooting(int shooting) {
        if (skillIsValid(shooting)) {
            this.shooting = shooting;
        } else {
            System.out.println("Shooting should be between 0 and 100.");

        }
    }

    public double overallSkillLevel() {
        return (this.endurance + this.dribble
                + this.passing + this.sprint + this.shooting) / 5.0;
    }

    private boolean skillIsValid(int skill) {
        return skill >= 0 && skill <= 100;
    }
}
