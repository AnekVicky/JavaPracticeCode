package com.java.designPatterns.designPatterns.chainOfResponsibilities.LeaveApplicationManagement;

/**
 * Created by anekkumarsingh on 2024-06-15 at 10:06:52
 */
public interface LeaveApprover {

    void processLeaveApplication(LeaveApplication leaveApplication);
    String getApprovedRole();
}
