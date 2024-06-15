package com.java.designPatterns.designPatterns.chainOfResponsibilities.RequestHandler;

/**
 * Created by anekkumarsingh on 2024-06-11 at 11:48:09
 */
public abstract class Handler {

    private Handler nextHandler;

    public Handler(Handler nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract boolean handle(String userName,String password,String roleName);

    public boolean handleNext(String userName, String password,String roleName){
        if(this.nextHandler == null) return true;
        return this.nextHandler.handle(userName,password,roleName);

    }

}
