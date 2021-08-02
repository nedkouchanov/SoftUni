package Reflection.barracksWars.core.factories;

import Reflection.barracksWars.interfaces.Unit;
import Reflection.barracksWars.interfaces.UnitFactory;
import Reflection.barracksWars.models.units.AbstractUnit;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "Reflection.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
        try {

            Class<?> unit = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> declaredConstructor = unit.getDeclaredConstructor();
            Object o = declaredConstructor.newInstance();
            if (o instanceof AbstractUnit) {
                return (Unit) o;
            }
        } catch (ClassNotFoundException | NoSuchMethodException |
                IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("Provided type is not a Unit");
    }
}
