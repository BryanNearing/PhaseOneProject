package phasePack;

import java.util.*;

public class Phase1Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("******************************************************");
		System.out.println("WELCOME");
		System.out.println("This project is the Phase End Project for Phase 1");
		System.out.println("This project was developed by Bryan Nearing");
		System.out.println("******************************************************");
		menu();

	}
	
	public static void menu() {
		System.out.println("Pick from one of the options");
		System.out.println("1) Return the file names in ascending order");
		System.out.println("2) User options");
		System.out.println("3) Exit the program");
		
		Scanner s = new Scanner(System.in);
		
		int choice = 0;
		
		try {
			choice = s.nextInt();
			s.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("The option you chose was not a number");
			System.out.println();
			menu();
		}
		
		switch(choice) {
		case 1:
			listFiles();
			break;
		case 2:
			userOptionsMenu(s);
			break;
		case 3:
			break;
		default:
			System.out.println("That option was not on the menu, select again.");
			menu();
			break;
		}
	}
	
	public static void listFiles() {
		System.out.println("Listing Files");
		
		menu();
	}
	
	public static void userOptionsMenu(Scanner s) {
		System.out.println("Pick from one of the options");
		System.out.println("1) Add a file");
		System.out.println("2) Delete a file");
		System.out.println("3) Search a file");
		System.out.println("4) Return to main menu");
		
		int choice = 0;
		
		try {
			choice = s.nextInt();
			s.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("The option you chose was not a number, please pick a number");
			System.out.println();
			userOptionsMenu(s);
		}
		
		switch(choice) {
		case 1:
			addFile(s);
			break;
		case 2:
			deleteFile(s);
			break;
		case 3:
			searchFile(s);
			break;
		case 4:
			menu();
			break;
		default:
			System.out.println("The number chosen was not on the menu, select again.");
			break;
		}
	}
	
	public static void addFile(Scanner s) {
		
		userOptionsMenu(s);
	}
	
	public static void deleteFile(Scanner s) {
		
		userOptionsMenu(s);
	}
	
	public static void searchFile(Scanner s) {
		
		userOptionsMenu(s);
	}

}
