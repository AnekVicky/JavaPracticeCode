package com.springbatch.practice.springbatchdata.config;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.database.support.DefaultDataFieldMaxValueIncrementerFactory;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.incrementer.DataFieldMaxValueIncrementer;
import org.springframework.jdbc.support.incrementer.PostgresSequenceMaxValueIncrementer;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//@Configuration
public class JobConfig {

    @Autowired
    private DataSource datasource;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Bean
    public JobRepository jobRepository() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(datasource);
        factory.setTransactionManager(platformTransactionManager);
        factory.setIncrementerFactory(new DefaultDataFieldMaxValueIncrementerFactory(datasource) {
            @Override
            public DataFieldMaxValueIncrementer getIncrementer(String incrementerType, String incrementerName) {
                return new PostgresSequenceMaxValueIncrementer(datasource, incrementerName);
            }
        });
        factory.afterPropertiesSet();
        return factory.getObject();
    }
    @Bean
    public JobLauncher jobLauncher(JobRepository jobRepository) {
        TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        return jobLauncher;
    }

}
