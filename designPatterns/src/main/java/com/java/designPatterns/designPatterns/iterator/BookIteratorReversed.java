package com.java.designPatterns.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by anekkumarsingh on 2024-06-17 at 10:15:05
 */
public class BookIteratorReversed implements Iterator{

    List<Book> list = new ArrayList<>();
    int cursor = 0;

    public BookIteratorReversed(List<Book> list) {
        this.list = list;
        this.cursor = list.size() - 1 ;
    }

    @Override // elements : 1 2 3 4 5 , index : 0 1 2 3 4
    public boolean hasNext() {
        return cursor >= 0;
    }

    @Override
    public Object next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return list.get(cursor--);
    }
}
