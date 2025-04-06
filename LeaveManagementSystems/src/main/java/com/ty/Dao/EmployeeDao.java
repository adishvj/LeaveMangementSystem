package com.ty.Dao;

import com.ty.Employee;
import com.ty.Login;

public interface EmployeeDao {

	public void saveEmployee(Login login,Employee employee);
	
	public void updateEmployee(int id);
}
