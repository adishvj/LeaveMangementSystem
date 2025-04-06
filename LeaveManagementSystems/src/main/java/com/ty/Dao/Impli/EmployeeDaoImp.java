package com.ty.Dao.Impli;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.Employee;
import com.ty.Login;
import com.ty.Dao.EmployeeDao;

public class EmployeeDaoImp implements EmployeeDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Scanner sc=new Scanner(System.in);
	@Override
	public void saveEmployee(Login login, Employee employee) {
		login.setType("employee");
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.out.println("Employee Registered Successfully!");
		
	}
	@Override
	public void updateEmployee(int id) {
		Employee emp =entityManager.find(Employee.class, id);
		if(emp==null)
		{
			System.out.println("The Id is Not found!");
		}
		else
		{
			System.out.println("What is The Thing you want to edit?");
			System.out.println("1 Edit name \n 2: Edit Email \n 3:Edit Phno");
			int choice2=sc.nextInt();
			if(choice2==1)
			{
				System.out.println("Enter the new name:?");
				String name1=sc.next();
				emp.setName(name1);
				System.out.println("Sucessfully Changed the name !");
			}
			else if(choice2==2)
			{
				System.out.println("Enter the new email:?");
				String email1=sc.next();
				emp.setEmailId(email1);
				System.out.println("Sucessfully Changed the email !");
			}
			else
			{
				System.out.println("Enter the new Phno:?");
				long phno1=sc.nextLong();
				emp.setPhno(phno1);
				System.out.println("Sucessfully Changed the phonenumber !");
			}
			
			entityTransaction.begin();
			entityManager.persist(emp);
			entityTransaction.commit();
			System.out.println("Employee Edited Successfully!");
			
		}
		
		
	}

}
