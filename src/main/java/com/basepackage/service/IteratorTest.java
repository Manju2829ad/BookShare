package com.basepackage.service;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(List.of("Mango", "Banana", "Orange", "Guava", "Litchi"));

        Iterator<String> i = fruits.iterator();

        while (i.hasNext()) {
        	i.next();
            i.remove();
            if (i.next().equals("Mango")) {
                i.remove(); // Now allowed
            }
        }

        System.out.println(fruits); // Mango will be removed
    }
}
