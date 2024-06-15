package com.java.designPatterns.designPatterns.chainOfResponsibilities.LeaveApplicationManagement;

/**
 * Created by anekkumarsingh on 2024-06-15 at 10:18:13
 */
public class ProjectLead extends Employee{

    ProjectLead(LeaveApprover nextApprover) {
        super("Project_Lead", nextApprover);
    }

    @Override
    public boolean process(LeaveApplication leaveApplication) {
        if(leaveApplication.getType().equals(LeaveApplication.Type.Sick) &&
                leaveApplication.getNumberOfDays() < 3){
                leaveApplication.approve(getApprovedRole());
            return true;
        }
        return false;
    }
}
