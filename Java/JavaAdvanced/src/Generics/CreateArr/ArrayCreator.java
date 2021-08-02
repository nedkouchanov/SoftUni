package Generics.CreateArr;

import java.lang.reflect.Array;

public class ArrayCreator {
    public static <T> T[] create(int length, T item) {
        return (T[]) new Object[length];
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        return (T[]) Array.newInstance(clazz, length);
    }
}
