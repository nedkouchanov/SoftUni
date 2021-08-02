package Generics.ExCustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {
    private List<E> list;
    public int size;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(E element) {
        this.size++;
        list.add(element);
    }

    public E remove(int index) {
        if (isNotInRange(index)) {
            return null;
        }
        this.size--;
        return list.remove(index);
    }

    public boolean contains(E element) {
        return list.contains(element);
    }

    public void swap(int index1, int index2) {
        if (isNotInRange(index1) || isNotInRange(index2)) {
            System.out.println("FirstIndex/SecondIndex is not valid!");
        }
        E first = this.list.get(index1);
        E second = this.list.get(index2);
        this.list.set(index1, second);
        this.list.set(index2, first);
    }

    public int countGreaterThan(E element) {
        int count = 0;
        for (E e : list) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public E getMax() {
        E max = this.list.get(0);
        for (E current : list) {
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }

    public E getMin() {
        E min = this.list.get(0);
        for (E current : list) {
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }
        return min;
    }


    public E get(int index) {
        if (isNotInRange(index)) {
            System.out.println("Index is not valid");
            return null;
        }
        return list.get(index);
    }

    private boolean isNotInRange(int index) {
        return index < 0 || index >= this.list.size();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public E next() {
                return list.get(index++);
            }
        };
    }
}
