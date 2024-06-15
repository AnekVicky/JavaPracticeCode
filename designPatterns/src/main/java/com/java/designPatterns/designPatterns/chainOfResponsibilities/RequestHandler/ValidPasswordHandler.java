package com.java.designPatterns.designPatterns.chainOfResponsibilities.RequestHandler;

/**
 * Created by anekkumarsingh on 2024-06-11 at 12:05:52
 */
public class ValidPasswordHandler extends Handler{

    private DatabaseUtility databaseUtility;

    ValidPasswordHandler(DatabaseUtility databaseUtility,Handler nextHandler){
        super(nextHandler);
        this.databaseUtility = databaseUtility;
    }
    @Override
    public boolean handle(String userName, String password,String roleName) {
        if(!databaseUtility.isValidPassword(password)){
            System.out.println("wrong password");
            return false;
        }
        return super.handleNext(userName,password, roleName);
    }
}
