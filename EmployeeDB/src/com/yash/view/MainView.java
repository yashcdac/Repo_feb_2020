package com.yash.view;

import java.util.Scanner;
import static com.yash.view.employee.AllEmployeeView.*;
import com.yash.helper.ScannerSupplier;
import com.yash.view.employee.AllEmployeeView;

import com.yash.view.employee.EmployeeRegistrationView;


public class MainView {

	public void mainMenu() {
		try (Scanner scanner = ScannerSupplier.getScannerSupplier().get()) {
			boolean exit = true;
			while (exit) {
				try {
					System.out.println("Enter your choice");
					System.out.println(
							"1. Get All Employees \n" + "2. Get Employee By Employee Id\n" + "3. Register Employee\n"
									+ "4. Update Employee\n" + "5. Delete Employee\n" + "6. Exit" + "\n");
					switch (scanner.nextInt()) {
					case 1:
						AllEmployeeView allEmployeeView=new AllEmployeeView();
						allEmployeeView.getAllEmployeeView();
						break;
					case 2:

						break;
					case 3:
						EmployeeRegistrationView.employeeRegistrationView();
						break;
					case 4:

						break;
					case 5:

						break;
					case 6:
						exit=false;
						break;

					default:
						System.out.println("Wrong choice please try again");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

	}

}
