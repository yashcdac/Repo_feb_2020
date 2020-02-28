package com.yash.view;

import java.util.Scanner;

public class MainView {

	public void mainMenu() {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean exit = true;
			while (exit) {
				try {
					System.out.println("Enter your choice");
					System.out.println(
							"1. Get All Employees \n" + "2. Get Employee By Employee Id\n" + "3. Register Employee\n"
									+ "4. Update Employee\n" + "5. Delete Employee\n" + "6. Exit" + "\n");
					switch (scanner.nextInt()) {
					case 1:

						break;
					case 2:

						break;
					case 3:

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
					// TODO: handle exception
				}

			}
		}

	}

}
