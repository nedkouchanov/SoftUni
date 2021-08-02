package IteratorsComparators.ExStrategyPattern;

import java.util.Comparator;

public class CompareByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length() > o2.getName().length()) {
            return 1;
        } else if (o1.getName().length() == o2.getName().length()) {
            if (o1.getName().toUpperCase().charAt(0) > o2.getName().toUpperCase().charAt(0)) {
                return 1;
            }
        }
        return -1;
    }

}


