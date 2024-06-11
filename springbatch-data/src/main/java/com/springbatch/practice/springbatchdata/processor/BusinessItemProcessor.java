package com.springbatch.practice.springbatchdata.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class BusinessItemProcessor implements ItemProcessor<Integer,Long> {
    @Override
    public Long process(Integer item) throws Exception {
        System.out.println("inside item processor ...");
        return Long.valueOf(item+10);
    }
}
