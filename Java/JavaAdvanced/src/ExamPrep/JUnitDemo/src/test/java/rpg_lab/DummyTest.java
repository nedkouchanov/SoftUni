package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    @Test
    public void testDummyLosesHealthIfAttacked() {
        Dummy dummy = new Dummy(10, 10);
        dummy.takeAttack(5);
        assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsIfAttacked() {
        Dummy dummy = new Dummy(0, 10);
        dummy.takeAttack(10);

    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsIfAttackedIfHealthIsBelowZero() {
        Dummy dummy = new Dummy(-1, 10);
        dummy.takeAttack(10);
    }

    @Test
    public void testDeadDummyCanGiveXp() {
        int expected = 10;
        int actual = new Dummy(0, 10).giveExperience();
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyWontGiveXp() {
        new Dummy(10, 10).giveExperience();

    }
}