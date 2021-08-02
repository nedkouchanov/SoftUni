package store;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StoreTests {
    private Store store;
    private Product p1;
    private Product p2;

    @Before
    public void setUp() {
        store = new Store();
        p1 = new Product("Cheese", 12, 14);
        p2 = new Product("Meat", 13, 15);
    }

    @Test
    public void test_getCount() {
        store.addProduct(p1);
        int expected = store.getCount();
        assertEquals(expected, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getProducts() {
        store.addProduct(p1);
        store.getProducts().add(p2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addNullProduct() {
        store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addProductZeroQuantity() {
        store.addProduct(new Product("Garlic", 0, 0));
    }

    @Test
    public void test_addProductWorks() {
        store.addProduct(p1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_buyNonExistingProduct() {
        store.addProduct(p1);
        store.buyProduct("Lesh", 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_buyProductNoQuantity() {
        store.addProduct(p1);
        store.buyProduct(p1.getName(), 30);
    }

    @Test
    public void test_buyProductWorksProperly() {
        store.addProduct(p1);
        double expected = store.buyProduct(p1.getName(), 2);
        assertEquals(expected, 28, 0.00);
        assertEquals(p1.getQuantity(), 10);
    }

    @Test
    public void test_getMostExpensive() {
        store.addProduct(p1);
        store.addProduct(p2);
        Product expected = store.getTheMostExpensiveProduct();
        assertEquals(expected.getName(), "Meat");
    }
}