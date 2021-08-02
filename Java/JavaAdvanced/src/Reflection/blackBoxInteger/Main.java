package Reflection.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Scanner scan = new Scanner(System.in);
        String line;
        BlackBoxInt blackBoxInt = null;
        try {
            Constructor<?> declaredConstructor = BlackBoxInt.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) declaredConstructor.newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        Map<String, Method> methdos = new HashMap<>();
        for (Method declaredMethod : blackBoxInt.getClass().getDeclaredMethods()) {
            methdos.put(declaredMethod.getName(), declaredMethod);
        }
        while (!(line = scan.nextLine()).equals("END")) {
            String[] tokens = line.split("_");
            Method method = methdos.get(tokens[0]);
            method.setAccessible(true);
            method.invoke(blackBoxInt, Integer.parseInt(tokens[1]));

            Field declaredField = blackBoxInt.getClass().getDeclaredFields()[1];
            declaredField.setAccessible(true);

            System.out.println(declaredField.getInt(blackBoxInt));
        }
    }
}