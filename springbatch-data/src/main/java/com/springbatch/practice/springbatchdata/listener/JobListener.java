package com.springbatch.practice.springbatchdata.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.stereotype.Component;

@Component
public class JobListener implements JobExecutionListener {

    @BeforeJob
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("---- beforeJob -------- "+jobExecution.getJobInstance().getJobName());
        System.out.println("---- beforeJob -------- "+jobExecution.getStartTime());

    }
    @AfterJob
    public void afterJob(JobExecution jobExecution) {
        System.out.println("---- afterJob -------- "+jobExecution.getEndTime());

    }
}

