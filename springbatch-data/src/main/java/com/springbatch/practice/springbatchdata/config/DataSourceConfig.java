package com.springbatch.practice.springbatchdata.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DataSourceConfig {

    @Value("${postgre.datasource.url}")
    private String postgreUrl;

    @Value("${postgre.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${postgre.datasource.username}")
    private String username;

    @Value("${postgre.datasource.password}")
    private String password;

    @Bean
    @ConfigurationProperties(prefix = "postgre.datasource")
    public DataSource dataSource() {
        System.out.println("username :: "+username);
        return DataSourceBuilder.create()
                .driverClassName(driverClassName)
                .url(postgreUrl)
                .username(username)
                .password(password)
                .build();
    }
}
