package com.java.designPatterns.designPatterns.iterator;

import lombok.Data;

/**
 * Created by anekkumarsingh on 2024-06-17 at 10:12:14
 */
@Data
public class Book {
    private final int price;
    private final String title;
    private final String author;

    public Book(int price, String title, String author) {
        this.price = price;
        this.title = title;
        this.author = author;
    }

}
