package Generics.CountDouble;


public class Box<E extends Comparable<E>> implements Comparable<E> {
    private E data;

    public Box(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + this.data;
    }

    @Override
    public int compareTo(E o) {
        return this.data.compareTo(o);
    }
}
