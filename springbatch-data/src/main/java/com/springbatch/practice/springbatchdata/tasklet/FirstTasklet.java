package com.springbatch.practice.springbatchdata.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class FirstTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("My First Tasklet : "+contribution.toString()+" , "+chunkContext.getStepContext().getStepName());
        return RepeatStatus.FINISHED;
    }
}
