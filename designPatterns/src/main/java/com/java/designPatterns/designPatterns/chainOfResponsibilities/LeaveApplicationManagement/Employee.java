package com.java.designPatterns.designPatterns.chainOfResponsibilities.LeaveApplicationManagement;

/**
 * Created by anekkumarsingh on 2024-06-15 at 10:08:17
 */
public abstract class Employee implements LeaveApprover{

    String role;
    LeaveApprover nextApprover;

    Employee(String role,LeaveApprover nextApprover){
        this.role = role;
        this.nextApprover = nextApprover;
    }

    public abstract boolean process(LeaveApplication leaveApplication);

    @Override
    public void processLeaveApplication(LeaveApplication leaveApplication) {

        if(!process(leaveApplication) && nextApprover !=null){
            this.nextApprover.processLeaveApplication(leaveApplication);
        }
        //System.out.println("Leave Approved for "+leaveApplication.getNumberOfDays()+" has been processed by "+this.role);

    }

    @Override
    public String getApprovedRole() {
        System.out.println("role :"+this.role);
        return this.role;
    }
}
