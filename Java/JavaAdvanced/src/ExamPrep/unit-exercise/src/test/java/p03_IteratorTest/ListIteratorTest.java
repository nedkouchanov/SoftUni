package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static ListIterator listIterator;

    @Before
    public void init() throws OperationNotSupportedException {
        listIterator = new ListIterator("Pesho", "Gosho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testConstructorShouldWorkProperly() {
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testHasNextShouldReturnFalse() {
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testHasNextShouldReturnTrue() {
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void testMoveShouldReturnFalse() {
        listIterator.move();
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMoveShouldReturnTrue() {
        assertTrue(listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowException() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintShouldWorkProperly() {
        String expected = "Pesho";
        String actual = listIterator.print();
        assertEquals(expected, actual);
    }
}