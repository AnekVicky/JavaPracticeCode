package com.java.designPatterns.designPatterns.chainOfResponsibilities.RequestHandler;

/**
 * Created by anekkumarsingh on 2024-06-11 at 12:09:04
 */
public class ValidRoleHandler extends Handler{

    private DatabaseUtility databaseUtility;

    ValidRoleHandler(DatabaseUtility databaseUtility,Handler nextHandler){
        super(nextHandler);
        this.databaseUtility = databaseUtility;
    }

    @Override
    public boolean handle(String userName, String password,String roleName) {
        if(this.databaseUtility.isValidRole(roleName)){
            //System.out.println("not authorized role");
            return true;
        }
        return super.handleNext(userName,password,roleName);
    }
}
