package org.example.comparators;

import org.example.WorkPerson;

import java.util.Comparator;

/**
 * Сортировать по возрасту
 */
public class AgeComp implements Comparator<WorkPerson> {
    @Override
    public int compare(WorkPerson o1, WorkPerson o2) {
        return o1.getAge() - o2.getAge();
    }
}
