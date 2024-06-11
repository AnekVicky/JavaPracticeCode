package com.springbatch.practice.springbatchdata.writer;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class TargetItemWriter implements ItemWriter<Long> {
    @Override
    public void write(Chunk chunk) throws Exception {
        System.out.println("inside item writer");
        System.out.println("item class : "+chunk.getItems().stream().findFirst().get().getClass());
        chunk.getItems().forEach(System.out::println);
    }
}
