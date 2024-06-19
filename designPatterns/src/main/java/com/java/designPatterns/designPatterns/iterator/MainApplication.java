package com.java.designPatterns.designPatterns.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by anekkumarsingh on 2024-06-17 at 10:57:38
 */
public class MainApplication {
    public static void main(String[] args) {

        LibraryAggregator libraryAgg = new LibraryAggregator();
                          libraryAgg.add(new Book(100,"Java","James"));
                          libraryAgg.add(new Book(500,"Data","Martin"));
                          libraryAgg.add(new Book(300,"Spark","Prashant"));

        /*iteratingAsItIs(libraryAgg);
        iteratingReversed(libraryAgg);
        iteratingDescendingByPrice(libraryAgg);*/

        iterate(libraryAgg,LibraryAggregator::iteratorAsc);
        iterate(libraryAgg,LibraryAggregator::iteratorReversed);
        iterate(libraryAgg,LibraryAggregator::iteratorDescending);

    }
    public static void iterate(LibraryAggregator libraryAgg, Function<LibraryAggregator,Iterator> function){
        Iterator iterator = function.apply(libraryAgg);
        while(iterator.hasNext()){
            Book book = (Book)iterator.next();
            System.out.println(book);
        }
    }
    public static void iteratingAsItIs(LibraryAggregator library){
        Iterator iteratorAsc = library.iteratorAsc();
        System.out.println("----- in order as added books  --------");
        while(iteratorAsc.hasNext()){
            Book book = (Book)iteratorAsc.next();
            System.out.println(book);
        }
    }
    public static void iteratingReversed(LibraryAggregator library){

        System.out.println("----- reversed books  --------");
        Iterator iteratorDes = library.iteratorReversed();

        while(iteratorDes.hasNext()){
            Book book = (Book) iteratorDes.next();
            System.out.println(book);
        }
    }
    public static void iteratingDescendingByPrice(LibraryAggregator library){

        System.out.println("----- descendingByPrice books  --------");
        Iterator iteratorDes = library.iteratorDescending();

        while(iteratorDes.hasNext()){
            Book book = (Book) iteratorDes.next();
            System.out.println(book);
        }
    }






}
