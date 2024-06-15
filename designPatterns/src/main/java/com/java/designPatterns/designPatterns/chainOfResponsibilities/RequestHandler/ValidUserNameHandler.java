package com.java.designPatterns.designPatterns.chainOfResponsibilities.RequestHandler;

/**
 * Created by anekkumarsingh on 2024-06-11 at 11:59:23
 */
public class ValidUserNameHandler extends Handler{
    private DatabaseUtility databaseUtility;

    ValidUserNameHandler(DatabaseUtility databaseUtility,Handler nextHandler){
        super(nextHandler);
        this.databaseUtility = databaseUtility;
    }

    @Override
    public boolean handle(String userName, String password,String roleName) {
        if(!this.databaseUtility.isValidUser(userName)){
            System.out.println("wrong username");
            return false;
        }
        return super.handleNext(userName,password, roleName);
    }
}
