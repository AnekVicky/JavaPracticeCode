package com.springbatch.practice.springbatchdata.config;

import com.springbatch.practice.springbatchdata.listener.JobListener;
import com.springbatch.practice.springbatchdata.processor.BusinessItemProcessor;
import com.springbatch.practice.springbatchdata.reader.SourceItemReader;
import com.springbatch.practice.springbatchdata.tasklet.FirstTasklet;
import com.springbatch.practice.springbatchdata.writer.TargetItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Autowired
    private JobRepository jobRepository;
    @Autowired
    DataSource datasource;
    @Autowired
    private FirstTasklet firstTasklet;
    @Autowired
    private SourceItemReader sourceItemReader;
    @Autowired
    private BusinessItemProcessor businessItemProcessor;
    @Autowired
    private TargetItemWriter targetItemWriter;
    @Autowired
    private JobListener jobListener;


    @Bean
    public Job job(JobRepository jobRepository,PlatformTransactionManager platformTransactionManager) throws Exception {
        System.out.println("First Job ...");
        return new JobBuilder("First Job",jobRepository)
            //.start(step1(jobRepository,platformTransactionManager))
            .listener(jobListener)
            .start(firstChunkStep(jobRepository,platformTransactionManager))
            .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,PlatformTransactionManager platformTransactionManager) throws Exception {
        System.out.println("First-step ...");
        return new StepBuilder("First-step",jobRepository)
                .tasklet(firstTasklet,platformTransactionManager)
                .build();
    }

    @Bean
    public Step firstChunkStep(JobRepository jobRepository,PlatformTransactionManager platformTransactionManager) throws Exception {
        System.out.println("firstChunkStep ...");
        return new StepBuilder("firstChunkStep",jobRepository)
                .<Integer,Long>chunk(3,platformTransactionManager)
                .reader(sourceItemReader)
                .processor(businessItemProcessor)
                .writer(targetItemWriter)
                .build();
    }



}
