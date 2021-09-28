package com.bank.test;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.bank.Login;
import com.bank.gui.LoginForm;
import com.bank.BankIO;

public class MainApp {

	public static void main(String[] args) {
		
		
		try {
			// create instance of the CreateLoginForm
			LoginForm form = new LoginForm();
			form.setSize(600, 400); // set size of the frame
			form.setVisible(true); // make form visible to the user
		} catch (Exception e) {
			// handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		
		
		
		
		
		
		
		System.out.println("Welcome to Bank");
		System.out.println(" ");
		System.out.println("Press 1 to Register.");
		System.out.println("Press 2 to Login.");
		System.out.println("Press any key to Exit");
		System.out.println(" ");
		Scanner scanner = new Scanner(System.in);
		BankIO input = new BankIO();
		System.out.println("Press any key:");
		int selectedOption = scanner.nextInt();
		switch (selectedOption) {
		case 1:
			input.registerUser();
			System.out.println("Registered Successfully !! Login Again");
			input.getUserCreditienals();
			if (Login.isLoggedIn()!=false) {
				showAfterLoginMenu();
			}
			else {
				System.out.println("Invalid Id and Password");
			}
			break;
		case 2:
			input.getUserCreditienals();
			if (Login.isLoggedIn()!=false) {
				showAfterLoginMenu();
			}
			else {
				System.out.println("Invalid Id and Password");
			}
			break;
		default:
			System.exit(0);
			break;
		}
//		scanner.close();
		
		
		

	
		
		
	}

	public static void showAfterLoginMenu() {

		BankIO input = new BankIO();
		System.out.println("Please Wait Logging you in...\n");
		System.out.println("Welcome to Xyz Bank\n");
		System.out.println("Please Select an option below:\n");
		System.out.println("Press 1 to Deposit Amount.");
		System.out.println("Press 2 to Withdraw Amount.");
		System.out.println("Press 3 to Print PassBook.");
		System.out.println("Press 4 to Export PassBook.");
		System.out.println("Press any key to Exit");
		System.out.println(" ");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press any key:");
		int selectedOption = scanner.nextInt();
		switch (selectedOption) {
		case 1:
			input.getUserDeposit();
			showAfterLoginMenu();
			break;
		case 2:
			input.getUserWithDrawal();
			showAfterLoginMenu();
			break;
		case 3:
			input.printPassBook();
//			showAfterLoginMenu();
			break;
		case 4:
			input.exportPassBook();
			showAfterLoginMenu();
			break;
		default:
			System.exit(0);
			break;
		}
		scanner.close();
		

	}
}
