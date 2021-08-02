package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer c1;
    private Computer c2;

    @Before
    public void setUp() {

        computerManager = new ComputerManager();
        c1 = new Computer("HP", "Omen", 1200);
        c2 = new Computer("ACER", "XOR", 1000);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getComputersThrowsBecauseUnmodifiableColl() {
        computerManager.addComputer(c1);
        computerManager.getComputers().add(c2);
    }

    @Test
    public void test_getCount() {
        computerManager.addComputer(c1);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addComputerThrowsBecauseNull() {
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addComputerThrowsBecauseAlreadyExist() {
        computerManager.addComputer(c1);
        computerManager.addComputer(new Computer("HP", "Omen", 1200));
    }

    @Test
    public void test_addComputerWorksProperly() {
        computerManager.addComputer(c1);
        Assert.assertEquals(computerManager.getComputers().get(0).getManufacturer(), c1.getManufacturer());
        Assert.assertEquals(computerManager.getComputers().get(0).getModel(), c1.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeComputerThrowsBecauseNotExist() {
        computerManager.removeComputer("Dell", "Da");
    }

    @Test
    public void test_removeComputerWorksProperly() {
        computerManager.addComputer(c1);
        computerManager.addComputer(c2);
        computerManager.removeComputer(c2.getManufacturer(), c2.getModel());
        Assert.assertEquals(computerManager.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getComputerThrowsBecauseNotExist() {
        computerManager.addComputer(c1);
        computerManager.getComputer("Dell", "Da");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getComputerThrowsBecauseNullManufacturer() {
        computerManager.getComputer(null, "Da");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getComputerThrowsBecauseNullModel() {
        computerManager.getComputer("HP", null);
    }

    @Test
    public void test_getComputerReturnsCorrectly() {
        computerManager.addComputer(c1);
        Computer returned = computerManager.getComputer(this.c1.getManufacturer(), this.c1.getModel());
        Assert.assertNotNull(returned);
        Assert.assertEquals(returned.getManufacturer(), this.c1.getManufacturer());
        Assert.assertEquals(returned.getModel(), this.c1.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_getComputersByManufacturerNullParam() {
        computerManager.getComputersByManufacturer(null);
    }


    @Test
    public void test_test_getComputersByManufacturerReturnsColl() {
        computerManager.addComputer(c1);
        computerManager.addComputer(c2);
        List<Computer> computersByManu = computerManager.getComputersByManufacturer(c2.getManufacturer());
        Assert.assertNotNull(computersByManu);
        Assert.assertEquals(c2.getManufacturer(), computersByManu.get(0).getManufacturer());
    }
}