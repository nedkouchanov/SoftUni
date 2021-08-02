package Inheritance.LabZoo;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private ArrayList<String> data;
    private int lastElementIndex;

    public StackOfStrings() {
        this.data = new ArrayList<>();
        this.lastElementIndex = -1;
    }

    public void push(String element) {
        this.lastElementIndex++;
        this.data.add(element);
    }

    public String pop() {
        ensureNonEmpty();
        return this.data.remove(this.lastElementIndex--);
    }

    public String peek() {
        ensureNonEmpty();
        return this.data.get((this.lastElementIndex));
    }

    private void ensureNonEmpty() {
        if (lastElementIndex < 0) {
            throw new NoSuchElementException("No such element");
        }
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
