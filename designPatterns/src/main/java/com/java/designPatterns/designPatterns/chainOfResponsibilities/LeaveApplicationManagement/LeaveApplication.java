package com.java.designPatterns.designPatterns.chainOfResponsibilities.LeaveApplicationManagement;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by anekkumarsingh on 2024-06-15 at 10:01:30
 */
@Data
public class LeaveApplication {

    public enum Type{Sick,PTO,LOP}
    public enum Status{Pending,Approved,Rejected}
    private Status status;
    private Type type;
    private LocalDate from;
    private LocalDate to;
    private String processedBy;

    public LeaveApplication(Type type,LocalDate from,LocalDate to){
        this.type = type;
        this.from = from;
        this.to = to;
        this.status = Status.Pending;
    }

    public int getNumberOfDays(){
        return Period.between(from,to).getDays();
    }
    public void approve(String approverName) {
        this.status = Status.Approved;
        this.processedBy = approverName;
    }

    public void reject(String approverName) {
        this.status = Status.Rejected;
        this.processedBy = approverName;
    }
    public String toString() {
        return type + " leave for "+getNumberOfDays()+" day(s) "+status
                + " by "+processedBy;
    }

}
