package com.ty.service;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.Employee;
import com.ty.Login;
import com.ty.Dao.Impli.EmployeeDaoImp;

public class EmployeeService {

	EmployeeDaoImp daoImp=new EmployeeDaoImp();
	
	public void saveEmployee(Login login,Employee employee)
	{
		EmployeeDaoImp daoImp=new EmployeeDaoImp();
		daoImp.saveEmployee(login, employee);
	}
	
	public void updateEmployee(int id)
	{
		EmployeeDaoImp daoImp=new EmployeeDaoImp();
		daoImp.updateEmployee(id);
	}
}
