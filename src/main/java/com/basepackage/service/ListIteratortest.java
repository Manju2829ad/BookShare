package com.basepackage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratortest {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(List.of("Mango", "Banana", "Orange", "Guava", "Litchi"));

        ListIterator<String> iter = fruits.listIterator();

        // Forward iteration: Removing all elements
        while (iter.hasNext()) {
            System.out.println("Removing: " + iter.next());
            iter.remove();
        }

        System.out.println("Fruits after removal: " + fruits); // Should be []

        // **Repopulate the list before iterating backward**
        fruits.addAll(List.of("Mango", "Banana", "Orange", "Guava", "Litchi"));

        // **Reset iterator to end of the list**
        iter = fruits.listIterator(fruits.size());

        // Backward iteration: Adding elements
        while (iter.hasPrevious()) {
            String fruit = iter.previous();
            System.out.println("Backward Iteration: " + fruit);
            iter.add(fruit + " (extra)"); // Add a modified version of the fruit
            // Don't call `.previous()` here, because `.add()` shifts the cursor forward
        }

        System.out.println("Final Fruits List: " + fruits);
    }
}
