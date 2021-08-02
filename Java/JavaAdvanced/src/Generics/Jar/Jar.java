package Generics.Jar;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<Type> {
    private Deque<Type> queue;

    public Jar() {
        this.queue = new ArrayDeque<>();
    }

    public void add(Type element) {
        this.queue.offer(element);
    }

    public Type remove() {
       return this.queue.poll();
    }
}
