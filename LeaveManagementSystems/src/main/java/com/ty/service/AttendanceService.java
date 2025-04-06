package com.ty.service;

import com.ty.Dao.Impli.AttandanceDaoImp;

public class AttendanceService {
	AttandanceDaoImp attandanceDaoImp=new AttandanceDaoImp();
	public void markAttendance(int id2)
	{
		attandanceDaoImp.markAttendance(id2);
	}
	public void appOrRejAttendance() 
	{
		attandanceDaoImp.appOrRejAttendance();
	}
}
