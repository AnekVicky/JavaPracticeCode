package com.java.designPatterns.designPatterns.chainOfResponsibilities.ex2;

/**
 * Created by anekkumarsingh on 2024-06-11 at 11:55:08
 */
public class DatabaseUtility {

    private String userName;
    private String password;
    private String roleName;

    public DatabaseUtility(){
        this.userName = "anek";
        this.password = "anekpass";
        this.roleName = "admin";
    }
    public boolean isValidUser(String userName){
        System.out.println("check valid userName");
        return userName.equals(this.userName);
    }
    public boolean isValidPassword(String password){
        System.out.println("check valid password");
        return password.equals(this.password);
    }
    public boolean isValidRole(String roleName){
        System.out.println("check valid roleName");
        return roleName.equals(this.roleName);
    }

}
