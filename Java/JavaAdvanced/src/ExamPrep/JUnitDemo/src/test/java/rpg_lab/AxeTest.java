package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AxeTest {
    @Test
    public void testDurabilityLossAfterAttackShouldLooseExactOnePoint() {
        //Arrange

        Axe axe = new Axe(0, 10);
        Dummy dummy = new Dummy(100, 100);
        // Act

        axe.attack(dummy);
        // Assert

        int expectedPoints = 9;
        int actualPoints = axe.getDurabilityPoints();
        assertTrue(expectedPoints == actualPoints);
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackWithBrokenAxeShouldThrow() {
        Axe axe = new Axe(10, 0);
        Dummy dummy = new Dummy(100, 100);
        axe.attack(dummy);

    }
}
