package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import java.util.Objects;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.isAlive = true;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.getHealth() > 0;
    }

    @Override
    public void takeDamage(int points) {
        if (this.getHealth() <= 0) {
            this.isAlive = false;
        }
        if (this.getArmor() - points < 0) {
            this.setArmor(0);
            this.setHealth(this.getHealth() - points);

        } else {
            this.setArmor(this.getArmor() - points);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s: %s",
                this.getClass().getSimpleName(), this.getUsername())).append(System.lineSeparator());
        sb.append(String.format("--Health: %d", this.getHealth())).append(System.lineSeparator());
        sb.append(String.format("--Armor: %d", this.getArmor())).append(System.lineSeparator());
        sb.append(String.format("--Gun: %s", this.getGun().getName()));
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerImpl player = (PlayerImpl) o;
        return health == player.health &&
                armor == player.armor &&
                isAlive == player.isAlive &&
                Objects.equals(username, player.username) &&
                Objects.equals(gun, player.gun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, health, armor, isAlive, gun);
    }
}
