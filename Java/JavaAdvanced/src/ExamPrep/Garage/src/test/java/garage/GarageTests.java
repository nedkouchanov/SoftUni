package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car car1;
    private Car car2;

    @Before
    public void setUp() {
        garage = new Garage();
        car1 = new Car("Audi", 220, 10000);
        car2 = new Car("Mercedes", 240, 12000);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getCarsReturnsUnmodifiableCollection() {
        garage.addCar(car1);
        garage.getCars().add(car2);
    }

    @Test
    public void test_getCountWorksProperly() {
        garage.addCar(car1);
        Assert.assertEquals(1, garage.getCount());
    }

    @Test
    public void test_findAllCarsWithMaxSpeedAboveWorksProperly() {
        garage.addCar(car1);
        garage.addCar(car2);
        List<Car> expected = new ArrayList<>();
        expected.add(car1);
        expected.add(car2);
        Assert.assertEquals(expected, garage.findAllCarsWithMaxSpeedAbove(200));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addCarThrowsBecauseNullCar() {
        garage.addCar(null);
    }

    @Test
    public void test_getMostExpensiveCarWorksProperly() {
        garage.addCar(car1);
        garage.addCar(car2);
        Car expected = car2;
        Assert.assertEquals(expected, garage.getTheMostExpensiveCar());
    }

    @Test
    public void test_findAllCarsByBrandWorksProperly() {
        garage.addCar(car1);
        garage.addCar(car2);
        List<Car> expected = new ArrayList<>();
        expected.add(car1);
        Assert.assertEquals(expected, garage.findAllCarsByBrand("Audi"));
    }
}