package IteratorsComparators.ExFroggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private int[] stones;
    private int currentIndex;

    public Lake(int[] stones) {
        this.stones = stones;
        currentIndex = 0;
    }

    @Override
    public Iterator iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return currentIndex < stones.length;
        }

        @Override
        public Integer next() {
            int stone = stones[currentIndex];
            currentIndex += 2;
            if (currentIndex >= stones.length && currentIndex % 2 == 0) {
                currentIndex = 1;
            }
            return stone;
        }
    }
}
