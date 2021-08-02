package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {
    private Astronaut astronaut1;
    private Astronaut astronaut2;
    private Spaceship spaceship;

    @Before
    public void setUp() {
        astronaut1 = new Astronaut("Ivan", 90);
        astronaut1 = new Astronaut("Petko", 50);
        spaceship = new Spaceship("Capt", 5);
    }

    @Test(expected = NullPointerException.class)
    public void test_CtorNullName() {
        spaceship = new Spaceship(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void test_CtorEmptyName() {
        spaceship = new Spaceship("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CtorZeroCapa() {
        spaceship = new Spaceship("Car", -1);
    }

    @Test
    public void test_CtorWorks() {
        spaceship = new Spaceship("Car", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddAstroSizeThr() {
        spaceship = new Spaceship("Capt", 1);
        spaceship.add(astronaut1);
        spaceship.add(astronaut2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_AddAstroTwice() {
        spaceship = new Spaceship("Capt", 5);
        spaceship.add(astronaut1);
        spaceship.add(astronaut1);
    }

    @Test
    public void test_AddAstro() {
        spaceship = new Spaceship("Capt", 5);
        spaceship.add(astronaut1);
    }

    @Test
    public void test_RemoveAstro() {
        spaceship = new Spaceship("Capt", 5);
        spaceship.add(new Astronaut("Pepi",25));
        Assert.assertEquals(true,spaceship.remove("Pepi"));
    }

    @Test
    public void test_RemoveAstroNull() {
        spaceship = new Spaceship("Capt", 5);
        spaceship.add(astronaut1);
        spaceship.remove(null);
    }

    @Test
    public void test_RemoveAstroNot() {
        spaceship = new Spaceship("Capt", 5);
        spaceship.add(astronaut1);
        Assert.assertEquals(false,spaceship.remove("Choco"));
    }

    @Test
    public void test_getName() {
        Assert.assertEquals("Capt", spaceship.getName());
    }
    @Test
    public void test_getCapacity() {
        Assert.assertEquals(5, spaceship.getCapacity());
    }
    @Test
    public void test_getCount() {
        spaceship.add(new Astronaut("Pepi",25));
        spaceship.add(new Astronaut("Samiy",45));
        Assert.assertEquals(2, spaceship.getCount());
    }
}
