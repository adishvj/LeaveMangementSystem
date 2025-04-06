package com.ty.service;

import com.ty.Dao.Impli.LeaveDaoImp;

public class LeaveService {
	LeaveDaoImp daoImp=new LeaveDaoImp();
	
	public void applyLeave(int id1)
	{
daoImp.applyLeave(id1);
	}

	public void approveOrRejectLave(int id)
	{
		daoImp.approveOrRejectLave(id);
	}
	
	public void addLeaveForEmp()  {
		daoImp.addLeaveForEmp();
		
	}

}
