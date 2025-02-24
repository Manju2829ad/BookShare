package com.basepackage.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class VectorTest {

    public static void main(String[] args) {

        Vector<String> books = new Vector<>(List.of(
                "Book 1", "Book 2", "Book 3", "Book 4", "Book 5",
                "Book 6", "Book 7", "Book 8", "Book 9", "Book 10",
                "Book 11", "Book 12", "Book 13", "Book 14", "Book 15"
        ));

        List<String> result = new ArrayList<>();
        int page = 0;  // Page 0 (First Page)
        int size = 5;  // Number of books per page
        int startIndex = page * size;
        int count = 0; // Counter to track book position

        Enumeration<String> e = books.elements();

        while (e.hasMoreElements()) {
            String book = e.nextElement();

            // ✅ Only add books within the requested page range
            if (count >= startIndex && count < startIndex + size) {
                result.add(book);
            }
            
            count++; // ✅ Increment count after each book
        }

        // ✅ Print only the paginated books
        System.out.println(result);
    }
}
