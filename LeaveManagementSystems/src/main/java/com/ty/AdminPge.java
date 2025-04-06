package com.ty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AdminPge {
	
	 public static void main(String[] args) {
	        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        EntityTransaction entityTransaction = entityManager.getTransaction();
	        Scanner sc = new Scanner(System.in);

	        System.out.println("Welcome Admin");

	        System.out.println("1. View Leave Requests and Approve/Reject");
	        System.out.println("2. Add Leave for Employee");
	        System.out.println("3. View Attendnce for Employee ,mark it as present or not");
	        System.out.println("4.Exit");
	        int choice = sc.nextInt();
while(true)
{
	        switch (choice) {
	            case 1:
	                Query query = entityManager.createQuery("select s from LeaveReuest s");
	                List<LeaveReuest> leaves = query.getResultList();

	                if (leaves.isEmpty()) {
	                    System.out.println("There are no leave requests.");
	                  
	                } else {
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

	                    Employee emp = entityManager.find(Employee.class, empId);

	                    if (emp != null) {
	                        List<LeaveReuest> empLeaves = emp.getLeaves();
	                        for (LeaveReuest leave : empLeaves) {
	                            System.out.println("Do you want to approve this leave? (yes/no)");
	                            String decision = sc.next();

	                            entityTransaction.begin();
	                            if (decision.equalsIgnoreCase("yes")) {
	                                leave.setAppOrRej(true);
	                                System.out.println("Leave approved.");
	                            } else {
	                                leave.setAppOrRej(false);
	                                System.out.println("Leave rejected.");
	                            }
	                            entityManager.merge(leave);
	                            entityTransaction.commit();
	                        }
	                    } else {
	                        System.out.println("Employee not found.");
	                    }
	                }
	                break;

	            case 2:
	                System.out.println(" Enter Employee id: ");
	                int id=sc.nextInt();
	                System.out.println("Enter the Leave Start Date : ");
	                String lsdate=sc.next();
	                System.out.println("Enter the Leave End Date : ");
	                String edate=sc.next();
	               System.out.println("Why you give leave for this perticular employee ? Reasomn ?");
	               String reason=sc.next();
	               Employee emp1 =entityManager.find(Employee.class, id);
	               LeaveReuest leaveReuest=new LeaveReuest();
	               leaveReuest.setAppOrRej(true);
	
	               leaveReuest.setLeaveEDate(edate);
	               leaveReuest.setLeaveSDate(lsdate);
	               leaveReuest.setReason(reason);
	               leaveReuest.setEmployee(emp1);
	               List<LeaveReuest> ls=new ArrayList<LeaveReuest>();
	               ls.add(leaveReuest);
	               emp1.setLeaves(ls);
	               entityTransaction.begin();
	               entityManager.persist(emp1);
	               entityManager.persist(leaveReuest);
	               entityTransaction.commit();
	                break;
	                
	            case 3:
	            	 Query query1 = entityManager.createQuery("select s from Attendance s");
		                List<Attendance> attendances = query1.getResultList();

		                if (attendances.isEmpty()) {
		                    System.out.println("There are no Attendance requests.");
		                } else {
		                    for (Attendance l : attendances) {
		                        System.out.println("---------------------------------------------------");
		                        System.out.println("Employee Id :   "+l.getEmployee().getId());
		                        System.out.println("Employee Name: " + l.getEmployee().getName());
		                        System.out.println("Employee Email: " + l.getEmployee().getEmailId());
		                        System.out.println("The Date: " + l.getDate());
		                        System.out.println("Approval Status: " + (l.isPreOrNot() ? "Present" : "Absent"));
		                        System.out.println("---------------------------------------------------");
		                    }

		                    System.out.println("Enter the Employee ID to mark Attendance: ");
		                    int empId = sc.nextInt();

		                    Employee emp = entityManager.find(Employee.class, empId);

		                    if (emp != null) {
		                        Attendance empAttendance = emp.getAttendance();
		                            System.out.println("Do you want to Mark this Attendance? (yes/no)");
		                            String decision = sc.next();

		                            entityTransaction.begin();
		                            if (decision.equalsIgnoreCase("yes")) {
		                                empAttendance.setPreOrNot(true);
		                                System.out.println("Attendance marked.");
		                            } else {
		                            	 empAttendance.setPreOrNot(false);
		                                System.out.println("Absent marked.");
		                            }
		                            entityManager.merge(empAttendance);
		                            entityTransaction.commit();
		                        
		                    } else {
		                        System.out.println("Employee not found.");
		                    }
		                }
		                break;
	            case 4:System.exit(0);
	            break;

	            default:
	                System.out.println("Invalid choice.");
	        }


	       
	    }
	 }

}
