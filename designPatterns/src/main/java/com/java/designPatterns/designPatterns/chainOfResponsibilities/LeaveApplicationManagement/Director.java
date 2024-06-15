package com.java.designPatterns.designPatterns.chainOfResponsibilities.LeaveApplicationManagement;

/**
 * Created by anekkumarsingh on 2024-06-15 at 10:22:23
 */
public class Director extends Employee{
    Director(LeaveApprover nextApprover) {
        super("Director", nextApprover);
    }

    @Override
    public boolean process(LeaveApplication leaveApplication) {
        if(leaveApplication.getType().equals(LeaveApplication.Type.LOP)){
            leaveApplication.approve(super.getApprovedRole());
            return true;
        }
        return false;
    }
}
