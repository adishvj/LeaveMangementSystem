package com.ty;

import javax.persistence.*;

@Entity
@Table(name = "LeaveReuest") 
public class LeaveReuest {  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String leaveSDate;
    private String leaveEDate;
    private boolean appOrRej;
    private String reason; 

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getLeaveSDate() { return leaveSDate; }
    public void setLeaveSDate(String leaveSDate) { this.leaveSDate = leaveSDate; }

    public String getLeaveEDate() { return leaveEDate; }
    public void setLeaveEDate(String leaveEDate) { this.leaveEDate = leaveEDate; }

    public boolean isAppOrRej() { return appOrRej; }
    public void setAppOrRej(boolean appOrRej) { this.appOrRej = appOrRej; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}