package IteratorsComparators.ExListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterable<String> {
    private List<String> list;
    private int currentIndex;

    public ListIterator(String... elements) {
        this.list = List.of(elements);
        this.currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < this.list.size()-1    ;
    }
    public boolean move(){
        if(hasNext()){
            currentIndex++;
        return true;
        }
        return false;
    }
    public void print(){
        if(this.list.size()==0){
            System.out.println("Invalid calculator.Operation!");
        } else {
            System.out.println(this.list.get((this.getCurrentIndex())));
        }
    }


    public List<String> getList() {
        return list;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }
    public void printAll(){
        for (String element : list) {
            System.out.printf("%s ",element);
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return ListIterator.this.hasNext();
            }

            @Override
            public String next() {
                return list.get(currentIndex++);
            }
        };
    }
}
