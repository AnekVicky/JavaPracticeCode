package com.java.designPatterns.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by anekkumarsingh on 2024-06-17 at 10:15:05
 */
public class BookIteratorAsc implements Iterator{

    List<Book> list = new ArrayList<>();
    int cursor = 0;

    public BookIteratorAsc(List<Book> list) {
        this.list = list;
    }

    @Override // elements : 1 2 3 4 5 , index : 0 1 2 3 4
    public boolean hasNext() {
        return cursor < list.size();
    }

    @Override
    public Object next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return list.get(cursor++);
    }
}
