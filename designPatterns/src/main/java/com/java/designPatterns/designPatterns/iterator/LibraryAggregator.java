package com.java.designPatterns.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anekkumarsingh on 2024-06-17 at 10:29:00
 */
//Aggregator
public class LibraryAggregator implements Aggregator{

    List<Book> bookList = new ArrayList<>();

    public LibraryAggregator() {
    }
    public void add(Book book){
        bookList.add(book);
    }
    @Override
    public Iterator iteratorAsc() {
        return new BookIteratorAsc(bookList);
    }

    @Override
    public Iterator iteratorReversed() {

        return new BookIteratorReversed(bookList);
    }

    @Override
    public Iterator iteratorDescending() {
        return new BookIteratorDescending(this.bookList);
    }

}
