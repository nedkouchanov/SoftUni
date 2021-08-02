import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InstockTest {
    private ProductStock stock;
    private Product testProduct;

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.testProduct = new Product("test_label", 10, 1);
    }

    @Test
    public void testAddShouldSaveProduct() {
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }

    @Test
    public void testContainsReturnsTrueForPreviouslyAddedProduct() {
        testAddShouldSaveProduct();

    }

    @Test
    public void testContainsShouldReturnFalseWhenProductIsNotPresent() {
        assertFalse(stock.contains(testProduct));
    }
}