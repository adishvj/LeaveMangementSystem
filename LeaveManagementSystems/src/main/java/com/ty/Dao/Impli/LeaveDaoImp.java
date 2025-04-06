package com.ty.Dao.Impli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.Employee;
import com.ty.LeaveReuest;
import com.ty.Dao.LeaveDao;

public class LeaveDaoImp implements LeaveDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Scanner sc=new Scanner(System.in);

	@Override
	public void applyLeave(int id) {
		Employee emp1 =entityManager.find(Employee.class, id);
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
		
	}

	@Override
	public void approveOrRejectLave(int id) {
        Employee emp = entityManager.find(Employee.class, id);

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

	@Override
	public void addLeaveForEmp() {
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
		
	}

}
