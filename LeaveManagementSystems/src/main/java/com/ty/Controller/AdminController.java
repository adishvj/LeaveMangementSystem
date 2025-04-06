package com.ty.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.LeaveReuest;
import com.ty.Login;
import com.ty.service.AttendanceService;
import com.ty.service.LeaveService;

public class AdminController {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("1:If you want to login in press 1");
		int choice=sc.nextInt();
		if (choice==1) {
			System.out.println("Enter The username: ");
			String username1=sc.next();
			System.out.println("Enter The Password: ");
			String password1=sc.next();
			Query query=entityManager.createQuery("select s from Login s where s.username=?1");
			query.setParameter(1, username1);
			List<Login>logins=query.getResultList();
			if(!logins.isEmpty())
//				here i given a username and based on the username if ididnt get login data we can say There is No User Name Like That
			{
				if(logins.get(0).getPassword().equals(password1))
				{
					System.out.println("Your Sucessfully loged in!");
					  System.out.println("Welcome Admin");

				        System.out.println("1. View Leave Requests and Approve/Reject");
				        System.out.println("2. Add Leave for Employee");
				        System.out.println("3. View Attendnce for Employee ,mark it as present or not");
				        System.out.println("4.Exit");
				        int choice1 = sc.nextInt();
				        while(true)
				        {
				        	switch (choice1) {
							case 1:  Query query1 = entityManager.createQuery("select s from LeaveReuest s");
			                List<LeaveReuest> leaves = query1.getResultList();

			                if (leaves.isEmpty()) {
			                    System.out.println("There are no leave requests.");
			                }
			                else
			                {
			                	 for (LeaveReuest l : leaves) {
				                        System.out.println("---------------------------------------------------");
				                        System.out.println("Employee Id :   "+l.getEmployee().getId());
				                        System.out.println("Employee Name: " + l.getEmployee().getName());
				                        System.out.println("Employee Email: " + l.getEmployee().getEmailId());
				                        System.out.println("Leave Start Date: " + l.getLeaveSDate());
				                        System.out.println("Leave End Date: " + l.getLeaveEDate());
				                        System.out.println("Approval Status: " + (l.isAppOrRej() ? "Approved" : "Pending"));
				                        System.out.println("---------------------------------------------------");
				                    }

				                    System.out.println("Enter the Employee ID to approve/reject leave: ");
				                    int empId = sc.nextInt();
				                    LeaveService leaveService=new LeaveService();
				                    leaveService.approveOrRejectLave(empId);
			                }
								
								break;
								
							case 2:LeaveService leaveService=new LeaveService();
							leaveService.addLeaveForEmp();
								
								break;
								
							case 3:AttendanceService attendanceService=new AttendanceService();
							attendanceService.appOrRejAttendance();
								
								break;
							 case 4:System.exit(0);
					            break;

							default:  System.out.println("Invalid choice.");
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
	}

}
