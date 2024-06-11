package com.springboot.multipledb.mysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "",
        basePackages = {"com.springboot.multipledb.mysql.repository"},
        transactionManagerRef = ""
)
public class MySqlDbConfig {
/*
Needs 3 Beans
1. DataSource
2. EntityManagerFactory Bean
3. PlatformTransactionManager Bean
 */
    @Autowired
    private Environment env;




}
