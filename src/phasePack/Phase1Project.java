package phasePack;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Phase1Project {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("******************************************************");
		System.out.println("WELCOME");
		System.out.println("This project is the Phase End Project for Phase 1");
		System.out.println("This project was developed by Bryan Nearing");
		System.out.println("******************************************************");
		menu();

	}
	
	public static void menu() throws IOException {
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
	
	public static void listFiles() throws IOException {
		
		 File directoryPath = new File(System.getProperty("user.dir"));
		 
		 String contents[] = directoryPath.list();
		 
		 Arrays.sort(contents);
		 
		 for(int i = 0; i < contents.length; i++) {
			 System.out.println(contents[i]);
		 }
		 System.out.println();
		
		menu();
	}
	
	public static void userOptionsMenu(Scanner s) throws IOException {
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
	
	public static void addFile(Scanner s) throws IOException {
		
		System.out.println("What is the name of the file you want to add?");
		String filename = s.nextLine();
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename));){
			
		}
		
		System.out.println();
		
		userOptionsMenu(s);
	}
	
	public static void deleteFile(Scanner s) throws IOException {
		System.out.println("What is the name of the file you want to delete?");
		String filename = s.nextLine();
		
		try{
			File file = new File(filename);
			file.delete();
		}
		catch(Exception e) {
			System.out.println("There was an " + e + " error with that filename");
		}
		
		System.out.println();
		
		userOptionsMenu(s);
	}
	
	public static void searchFile(Scanner s) throws IOException {
		
		System.out.println("What is the name of the file you would like to look for?");
		String filename = s.nextLine();
		
		 File directoryPath = new File(System.getProperty("user.dir"));
		 
		 String contents[] = directoryPath.list();
		 
		 boolean found = false;
		 
		 for(int i = 0; i < contents.length; i++) {
			 if(filename.equals(contents[i]))
				 found = true;
		 }
		 
		 if(found == true)
			 System.out.println("The file was found in the directory");
		 else
			 System.out.println("The file was not found in the directory");
		 
		 System.out.println();
		
		userOptionsMenu(s);
	}

}
