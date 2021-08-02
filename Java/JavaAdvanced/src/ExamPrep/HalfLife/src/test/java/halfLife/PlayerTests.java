package halfLife;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTests {
    @Test(expected = NullPointerException.class)
    public void testUsernameShouldThrowException() {
        Player player = new Player(null, 50);
    }

    @Test
    public void testUsernameShouldWork() {
        Player player = new Player("Pesho", 50);
        assertEquals("Pesho", player.getUsername());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHealthShouldThrowException() {
        Player player = new Player("Pesho", -50);
    }

    @Test
    public void testHealthShouldWork() {
        Player player = new Player("Pesho", 50);
        assertEquals(50, player.getHealth());
    }

    @Test
    public void testGunsShouldWork() {
        Gun gun = new Gun("AK47", 10);
        Player player = new Player("Pesho", 50);
        player.addGun(gun);
        List<Gun> expected = List.of(gun);
        assertEquals(expected, player.getGuns());
    }

    @Test
    public void testTakeDmgShouldWork() {
        Player player = new Player("Pesho", 50);
        player.takeDamage(5);

        assertEquals(45, player.getHealth());
    }

    @Test
    public void testTakeDmgShouldWorkV2() {
        Player player = new Player("Pesho", 5);
        player.takeDamage(5);
        assertEquals(0, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDmgShouldThrowException() {
        Player player = new Player("Pesho", 0);
        player.takeDamage(10);
    }

    @Test
    public void testAddGunDmgShouldWork() {
        Player player = new Player("Pesho", 50);
        Gun gun = new Gun("AK47", 10);
        player.addGun(gun);

        assertEquals(List.of(gun), player.getGuns());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunDmgShouldThrowException() {
        Player player = new Player("Pesho", 50);
        player.addGun(null);
    }

    @Test
    public void testRemoveGunDmgShouldWork() {
        Player player = new Player("Pesho", 50);
        Gun gun = new Gun("AK47", 10);
        player.addGun(gun);
        assertTrue(player.removeGun(gun));
    }

    @Test
    public void testGetGunDmgShouldWork() {
        Player player = new Player("Pesho", 50);
        Gun gun = new Gun("AK47", 10);
        player.addGun(gun);
        assertEquals(gun, player.getGun("AK47"));
    }

    @Test
    public void testGetGunDmgShouldReturnNull() {
        Player player = new Player("Pesho", 50);
        Gun gun = new Gun("AK47", 10);
        player.addGun(gun);
        assertEquals(null, player.getGun("Gosho"));
    }
}
