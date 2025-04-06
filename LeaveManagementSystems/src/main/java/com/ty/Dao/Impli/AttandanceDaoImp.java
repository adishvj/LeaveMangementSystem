package com.ty.Dao.Impli;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.Attendance;
import com.ty.Employee;
import com.ty.Dao.AttendanceDao;

public class AttandanceDaoImp implements AttendanceDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Scanner sc=new Scanner(System.in);

	@Override
	public void markAttendance(int id2) {
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
		System.out.println("SucessFully Marked The Attendance !");
		
	}

	@Override
	public void appOrRejAttendance() {
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
		
	}

}
