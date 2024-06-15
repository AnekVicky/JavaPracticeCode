package com.java.designPatterns.designPatterns.chainOfResponsibilities.LeaveApplicationManagement;

import java.time.LocalDate;

/**
 * Created by anekkumarsingh on 2024-06-15 at 10:33:11
 */
public class MainApplication {
    public static void main(String[] args) {

        LeaveApplication leaveApplication = new LeaveApplication(LeaveApplication.Type.LOP,
                LocalDate.now(),LocalDate.of(2024,06,29));

        System.out.println(leaveApplication);

        LeaveApprover approver = new ProjectLead(new Manager(new Director(null)));
        approver.processLeaveApplication(leaveApplication);

        System.out.println(leaveApplication);

    }
}
