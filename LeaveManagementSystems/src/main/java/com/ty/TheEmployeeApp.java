//package com.ty;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//public class TheEmployeeApp {
//	public static void main(String[] args) {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("...............Welcome Employee's...................");
//		System.out.println("1:If you want to Sighn up press 1");
//		System.out.println("1:If you want to login up press 2");
//		int choice=sc.nextInt();
//		while(true)
//		{
//		switch (choice) {
//		case 1:
//			System.out.println("Enter the name: ");
//			String name = sc.next();
//
//			System.out.println("Enter the EmailId: ");
//			String email = sc.next();
//
//			System.out.println("Enter the Phno: ");
//			long phno = sc.nextLong();
//            System.out.println("Enter the username: ");
//            String username=sc.next();
//            System.out.println("Enter The password: ");
//            String password=sc.next();
//			Employee employee = new Employee();
//			employee.setName(name);  
//			employee.setEmailId(email);
//			employee.setPhno(phno);
//			Login login=new Login();
//			login.setUsername(username);
//			login.setPassword(password);
//			login.setEmployee(employee);
//			employee.setLoginData(login);
//			
//
//			entityTransaction.begin();
//			entityManager.persist(employee);
//			entityTransaction.commit();
//			System.out.println("Employee Registered Successfully!");
//			
//			break;
//			
//		case 2:System.out.println("Enter The username: ");
//		String username1=sc.next();
//		System.out.println("Enter The Password: ");
//		String password1=sc.next();
//		Query query=entityManager.createQuery("select s from Login s where s.username=?1");
//		query.setParameter(1, username1);
//		List<Login>logins=query.getResultList();
//		if(logins.get(0).getPassword().equals(password1))
//		{
//			System.out.println("Your Sucessfully loged in!");
//			while(true)
//			{
//			System.out.println("............Welcome Employees..........");
//			System.out.println("--------------------------");
//			System.out.println("Enter the Option you want!");
//			System.out.println("1 Edit Profile \n2: Apply For Leave \n3: Mark The Attendance\n 4 Exit:");
//			int choice1=sc.nextInt();
//			switch (choice1) {
//			case 1:
//				System.out.println("Enter The id for the eployee: ?");
//				int id=sc.nextInt();
//				Employee emp =entityManager.find(Employee.class, id);
//				if(emp==null)
//				{
//					System.out.println("The Id is Not found!");
//				}
//				else
//				{
//					System.out.println("What is The Thing you want to edit?");
//					System.out.println("1 Edit name \n 2: Edit Email \n 3:Edit Phno");
//					int choice2=sc.nextInt();
//					if(choice2==1)
//					{
//						System.out.println("Enter the new name:?");
//						String name1=sc.next();
//						emp.setName(name1);
//						System.out.println("Sucessfully Changed the name !");
//					}
//					else if(choice2==2)
//					{
//						System.out.println("Enter the new email:?");
//						String email1=sc.next();
//						emp.setEmailId(email1);
//						System.out.println("Sucessfully Changed the email !");
//					}
//					else
//					{
//						System.out.println("Enter the new Phno:?");
//						long phno1=sc.nextLong();
//						emp.setPhno(phno1);
//						System.out.println("Sucessfully Changed the phonenumber !");
//					}
//					
//					entityTransaction.begin();
//					entityManager.persist(emp);
//					entityTransaction.commit();
//					System.out.println("Employee Edited Successfully!");
//					
//				}
//				
//				break;
//				
//				
//			case 2:
//				System.out.println("Enter The id for the Employee ? ");
//				int id1=sc.nextInt();
//				Employee emp1 =entityManager.find(Employee.class, id1);
//				LeaveReuest leaveReuest=new LeaveReuest();
//				System.out.println("Enter the Leave Start Date (YYYY-MM-DD) ?");
//				String sdate=sc.next();
//				leaveReuest.setLeaveSDate(sdate);
//				
//				System.out.println("Enter the Leave End Date (YYYY-MM-DD) ?");
//				String edate=sc.next();
//				leaveReuest.setLeaveEDate(edate);
//				
//				
//				System.out.println("Enter the  Reason for Leave  ?");
//				String reason=sc.next();
//				leaveReuest.setReason(reason);
//				leaveReuest.setEmployee(emp1);
//				List<LeaveReuest>list=new ArrayList<LeaveReuest>();
//				list.add(leaveReuest);
//				
//				emp1.setLeaves(list);
//				
//				leaveReuest.setAppOrRej(false);
//				entityTransaction.begin();
//				entityManager.persist(leaveReuest);
//				entityManager.persist(emp1);
//				
//				entityTransaction.commit();
//				System.out.println("SucessFully apply for Leave !");
//				
//				break;
//				
//			case 3:
//			System.out.println("Enter The Id for The employee ");
//			int id2=sc.nextInt();
//			Employee emp2 =entityManager.find(Employee.class, id2);
//			System.out.println("Enter the Date Today for mark attendence ");
//			String date1=sc.next();
//			Attendance attendance=new Attendance();
//			attendance.setDate(date1);
//			attendance.setPreOrNot(false);
//			emp2.setAttendance(attendance);
//			attendance.setEmployee(emp2);
//			
//			entityTransaction.begin();
//			entityManager.persist(attendance);
//			entityManager.persist(emp2);
//			entityTransaction.commit();
//			System.out.println("SucessFully Marked THE Attendance !");
//			break;
//			case 4:System.exit(0);
//			default:
//			System.out.println("Invalid Option");
//				break;
//			}
//			
//			}
//			
//			
//			
//		}
//		else
//		{
//			System.out.println("Your Password is Not Correct!");
//		}
//		
//			
//			break;
//			
//			
//			case 3:System.exit(0);
//			break;
//
//		default:System.out.println("Invalid Option");
//			break;
//		}
//		
//		
//		
//		}
//	}
//
//}


package com.ty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TheEmployeeApp {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("...............Welcome Employee's...................");
		System.out.println("1:If you want to Sighn up press 1");
		System.out.println("1:If you want to login up press 2");
		int choice=sc.nextInt();
		
		
		if (choice==1) {
			System.out.println("Enter the name: ");
			String name = sc.next();

			System.out.println("Enter the EmailId: ");
			String email = sc.next();

			System.out.println("Enter the Phno: ");
			long phno = sc.nextLong();
            System.out.println("Enter the username: ");
            String username=sc.next();
            System.out.println("Enter The password: ");
            String password=sc.next();
			Employee employee = new Employee();
			employee.setName(name);  
			employee.setEmailId(email);
			employee.setPhno(phno);
			Login login=new Login();
			login.setUsername(username);
			login.setPassword(password);
			login.setEmployee(employee);
			employee.setLoginData(login);
			

			entityTransaction.begin();
			entityManager.persist(employee);
			entityTransaction.commit();
			System.out.println("Employee Registered Successfully!");
		}
			
		else if(choice==2)
		{
			
		System.out.println("Enter The username: ");
		String username1=sc.next();
		System.out.println("Enter The Password: ");
		String password1=sc.next();
		Query query=entityManager.createQuery("select s from Login s where s.username=?1");
		query.setParameter(1, username1);
		List<Login>logins=query.getResultList();
		if(!logins.isEmpty())
		{
		if(logins.get(0).getPassword().equals(password1))
		{
			System.out.println("Your Sucessfully loged in!");
			while(true)
			{
			System.out.println("............Welcome Employees..........");
			System.out.println("--------------------------");
			System.out.println("Enter the Option you want!");
			System.out.println("1 Edit Profile \n2: Apply For Leave \n3: Mark The Attendance\n 4 Exit:");
			int choice1=sc.nextInt();
			switch (choice1) {
			case 1:
				System.out.println("Enter The id for the eployee: ?");
				int id=sc.nextInt();
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
				
				break;
				
				
			case 2:
				System.out.println("Enter The id for the Employee ? ");
				int id1=sc.nextInt();
				Employee emp1 =entityManager.find(Employee.class, id1);
				LeaveReuest leaveReuest=new LeaveReuest();
				System.out.println("Enter the Leave Start Date (YYYY-MM-DD) ?");
				String sdate=sc.next();
				leaveReuest.setLeaveSDate(sdate);
				
				System.out.println("Enter the Leave End Date (YYYY-MM-DD) ?");
				String edate=sc.next();
				leaveReuest.setLeaveEDate(edate);
				
				
				System.out.println("Enter the  Reason for Leave  ?");
				String reason=sc.next();
				leaveReuest.setReason(reason);
				leaveReuest.setEmployee(emp1);
				List<LeaveReuest>list=new ArrayList<LeaveReuest>();
				list.add(leaveReuest);
				
				emp1.setLeaves(list);
				
				leaveReuest.setAppOrRej(false);
				entityTransaction.begin();
				entityManager.persist(leaveReuest);
				entityManager.persist(emp1);
				
				entityTransaction.commit();
				System.out.println("SucessFully apply for Leave !");
				
				break;
				
			case 3:
			System.out.println("Enter The Id for The employee ");
			int id2=sc.nextInt();
			Employee emp2 =entityManager.find(Employee.class, id2);
			System.out.println("Enter the Date Today for mark attendence ");
			String date1=sc.next();
			Attendance attendance=new Attendance();
			attendance.setDate(date1);
			attendance.setPreOrNot(false);
			emp2.setAttendance(attendance);
			attendance.setEmployee(emp2);
			
			entityTransaction.begin();
			entityManager.persist(attendance);
			entityManager.persist(emp2);
			entityTransaction.commit();
			System.out.println("SucessFully Marked THE Attendance !");
			break;
			case 4:System.exit(0);
			default:
			System.out.println("Invalid Option");
				break;
			}
			
			}
		
			
			
			
		}
		else
		{
			System.out.println("Your Password is Not Correct!");
		}
		}
		else
		{
			System.out.println("There is No User Name Like That");
		}
		
			
		}
			
			
		else
		{
			System.out.println("Invalid Option.....");
		}
		
		
		
		
	}

}
