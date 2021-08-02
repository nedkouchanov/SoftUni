package computers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {
    private Computer computer;

    @Before
    public void setUp() {
        this.computer = new Computer("Test_Name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWithNullAsName() {
        new Computer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorShouldThrowWithEmptyName() {
        new Computer("");
    }

    @Test
    public void testConstructorShouldTWorkProperly() {
        assertEquals("Test_Name", computer.getName());
    }

    @Test
    public void testGetPartsShouldReturnCollection() {
        assertNotNull(this.computer.getParts());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPartsShouldReturnUnmodifiableCollection() {
        this.computer.getParts().add(new Part("test", 13));
    }

    @Test
    public void testGetTotalPriceShouldReturnZeroWhenEmpty() {
        double totalPrice = this.computer.getTotalPrice();
        assertEquals(0.00, totalPrice, 0.00);
    }

    @Test
    public void testGetTotalPriceShouldWhenNotEmpty() {
        this.computer.addPart(new Part("Part", 13));
        this.computer.addPart(new Part("Part", 13));
        double totalPrice = this.computer.getTotalPrice();
        assertEquals(26.00, totalPrice, 0.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPartShouldThrow() {
        this.computer.addPart(null);
    }

    @Test
    public void testAddPartShouldAddPart() {
        this.computer.addPart(new Part("Part", 13));
        assertNotNull(this.computer.getPart("Part"));
    }

    @Test
    public void testRemovePart() {
        Part part = new Part("Part", 13);
        assertFalse(this.computer.removePart(part));
        this.computer.addPart(part);
        assertTrue(this.computer.removePart(part));
    }

    @Test
    public void testGetPartShouldReturnNull() {
        assertNull(this.computer.getPart("Part"));
    }

    @Test
    public void testGetPartShouldReturnTheSamePart() {
        Part part = new Part("Part", 13);
        this.computer.addPart(part);
        assertNotNull(this.computer.getPart("Part"));
    }
}