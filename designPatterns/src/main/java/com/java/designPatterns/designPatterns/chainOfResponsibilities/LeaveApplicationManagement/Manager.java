package com.java.designPatterns.designPatterns.chainOfResponsibilities.LeaveApplicationManagement;

/**
 * Created by anekkumarsingh on 2024-06-15 at 10:21:59
 */
public class Manager extends Employee{

    Manager(LeaveApprover nextApprover) {
        super("Manager", nextApprover);
    }

    @Override
    public boolean process(LeaveApplication leaveApplication) {
        if(leaveApplication.getType().equals(LeaveApplication.Type.PTO)){
            leaveApplication.approve(getApprovedRole());
            return true;
        }
        return false;
    }
}
