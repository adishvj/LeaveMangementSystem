package com.ty.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.Employee;
import com.ty.Login;
import com.ty.service.AttendanceService;
import com.ty.service.EmployeeService;
import com.ty.service.LeaveService;

public class EmployeeController {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("...............Welcome Employee's...................");
		System.out.println("1:If you want to Sighn up press 1");
		System.out.println("2:If you want to login up press 2");
		int choice=sc.nextInt();
		
		if (choice==1) {
		



			// Add this line if you've used sc.nextInt() or sc.next() before
			sc.nextLine(); // clears the leftover newline from previous input

			System.out.println("Enter the name: ");
			String name = sc.nextLine();

			System.out.println("Enter the EmailId: ");
			String email = sc.nextLine();

			System.out.println("Enter the Phno: ");
			long phno = sc.nextLong();
			sc.nextLine(); // clear buffer again

			System.out.println("Enter the username: ");
			String username = sc.nextLine();

			System.out.println("Enter the password: ");
			String password = sc.nextLine();
			Employee employee = new Employee();
			employee.setName(name);  
			employee.setEmailId(email);
			employee.setPhno(phno);
			Login login=new Login();
			login.setUsername(username);
			login.setPassword(password);
			login.setEmployee(employee);
			employee.setLoginData(login);
			
			EmployeeService employeeService=new EmployeeService();
			employeeService.saveEmployee(login, employee);
	}
		else if (choice==2) {
			
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
//					here the password is check for the given username
					
					System.out.println("Your Sucessfully loged in!");
					
					while (true) {
						System.out.println("............Welcome Employees..........");
						System.out.println("--------------------------");
						System.out.println("Enter the Option you want!");
						System.out.println("1 Edit Profile \n2: Apply For Leave \n3: Mark The Attendance\n 4 Exit:");
						int choice1=sc.nextInt();
						switch (choice1) {
						case 1:
							System.out.println("Enter The id for the eployee: ?");
							int id=sc.nextInt();
							EmployeeService employeeService=new EmployeeService();
							employeeService.updateEmployee(id);
							break;
							
						case 2:
							System.out.println("Enter The id for the Employee ? ");
							int id1=sc.nextInt();
							LeaveService leaveService=new LeaveService();
							leaveService.applyLeave(id1);
							break;
						case 3:System.out.println("Enter The Id for The employee ");
						     int id2=sc.nextInt();	
						     AttendanceService attendanceService=new AttendanceService();
						     attendanceService.markAttendance(id2);
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
		
		
		

}
}
