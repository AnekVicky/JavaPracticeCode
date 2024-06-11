package com.java.designPatterns.designPatterns.chainOfResponsibilities.ex2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by anekkumarsingh on 2024-06-11 at 12:14:23
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class,args);
        DatabaseUtility databaseUtility = new DatabaseUtility();

        Handler handler = new ValidUserNameHandler(databaseUtility,
                               new ValidPasswordHandler(databaseUtility,
                                    new ValidRoleHandler(databaseUtility,null)
                                    ));

        String userName = "anek";
        String password = "anekpass";
        String roleName = "admin";

        boolean valid = handler.handle(userName,password,roleName);
        System.out.println(valid);
    }
}
