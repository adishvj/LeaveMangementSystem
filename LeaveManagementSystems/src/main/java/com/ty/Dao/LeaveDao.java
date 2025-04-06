package com.ty.Dao;

public interface LeaveDao {
	public void applyLeave(int id);

	
	public void approveOrRejectLave(int id);
	
	public void addLeaveForEmp();
}
