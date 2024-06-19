package com.java.designPatterns.designPatterns.iterator;

/**
 * Created by anekkumarsingh on 2024-06-17 at 10:32:13
 */
public interface Aggregator {
     Iterator iteratorAsc();
     Iterator iteratorReversed();
     Iterator iteratorDescending();
}
