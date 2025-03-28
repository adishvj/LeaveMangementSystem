package com.ty;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String emailId;
	private long phno;

	@OneToMany(mappedBy = "employee")
	private List<LeaveReuest> leaves; 

	@OneToOne(mappedBy = "employee")
	private Attendance attendance;
	
	@OneToOne(mappedBy = "employee",cascade = CascadeType.PERSIST)
	private Login loginData;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public List<LeaveReuest> getLeaves() {
		return leaves;
	}

	public void setLeaves(List<LeaveReuest> leaves) {
		this.leaves = leaves;
	}

	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	public Login getLoginData() {
		return loginData;
	}

	public void setLoginData(Login loginData) {
		this.loginData = loginData;
	}

}
