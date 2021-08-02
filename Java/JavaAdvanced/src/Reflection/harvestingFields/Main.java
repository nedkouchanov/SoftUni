package Reflection.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();
        String line;
        while (!(line = scan.nextLine()).equals("HARVEST")) {
            for (Field declaredField : declaredFields) {
                String modifierName = Modifier.toString(declaredField.getModifiers());
                if (line.equals(modifierName) || line.equals("all")) {
                    System.out.printf("%s %s %s%n",
                            modifierName, declaredField.getType().getSimpleName(),
                            declaredField.getName());
                }
            }
        }
    }
}
