package com.yash.view.employee;

import java.time.LocalDate;
import java.util.Scanner;

import com.yash.controller.EmployeeController;
import com.yash.entities.Employee;
import com.yash.helper.ScannerSupplier;

public class EmployeeRegistrationView {
	public static void employeeRegistrationView() throws Exception {
		Scanner sc=ScannerSupplier.getScannerSupplier().get();
		Boolean flag = true;
		try {
			while (flag) {
				System.out.println(" employee registration view");
				int employeeId;
				 String firstName;
				 String lastName;
				 String email;
				String phoneNumber;
				 LocalDate hireDate;
				 double salary;
				 double commissionPct;
				while(true) {
					System.out.println("please give employee id");
					if(sc.hasNextInt())
					{
						employeeId= sc.nextInt();
						break;
					}
				}
				System.out.println("please give  first name");
				firstName = sc.next();
				System.out.println("please give  last name");
				lastName = sc.next();			
				System.out.println("please give  email");
				email=sc.next();
				System.out.println("please give  phone number");
				phoneNumber=sc.next();
				System.out.println("please give  hire date");
				hireDate=LocalDate.parse(sc.next());
				System.out.println("please give  salary");
				salary=sc.nextDouble();
				System.out.println("please give  commision pct");
				commissionPct=sc.nextDouble();
				Employee employee=new Employee();
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setEmail(email);
				employee.setPhoneNumber(phoneNumber);
				employee.setHireDate(hireDate);
				employee.setSalary(salary);
				employee.setCommissionPct(commissionPct);
				EmployeeController controller=new EmployeeController();
				controller.insertEmployee(employee);
				boolean flag2=true;
				while (flag2) {
					System.out.println("1.register new employee");
					System.out.println("2.main menu");
					int option = sc.nextInt();
					switch (option) {
					case 1:{
						flag = true;
						flag2 = false;
						break;
					}
					case 2: {
						flag = false;
						flag2 = false;
						
						break;
					}
					default: {
						System.out.println("choose proper option");
						break;
					}
					}
				}
			}
		}finally {
			
		}
	}
}
