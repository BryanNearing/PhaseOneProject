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
		Scanner s = new Scanner(System.in);
		
		System.out.println("******************************************************");
		System.out.println("WELCOME to Lock.me");
		System.out.println("This project is the Phase End Project for Phase 1");
		System.out.println("This project was developed by Bryan Nearing");
		System.out.println("******************************************************");
		File dirPath = null;
		menu(s, dirPath);

	}
	
	public static void menu(Scanner s, File dirPath) throws IOException {
		
		boolean exists = false;
		
		
		if(dirPath == null)
			dirPath = new File(System.getProperty("user.dir"));
		
		System.out.println("The current directory you are in is " + dirPath.getAbsolutePath() + "\nWould you like to change that? (y/n)");
		String userInput = s.nextLine();
		
		if(userInput.equals("y")) {
			while(exists == false) {
				System.out.println("Please list the directory you would like to enter.");
				String filePath = s.nextLine();
				
				dirPath = new File(filePath);
				
				if(dirPath.exists()) {
					System.out.println("Thank you, you are now in the directory at " + filePath);
					exists = true;
				}
				else {
					System.out.println("That directory does not exist");
				}
			
			}
		}
		else if(userInput.equals("n")) {
			System.out.println("Thank you, you are working in the " + dirPath.getAbsolutePath() + " directory");
		}
		else {
			System.out.println("That was not one of the options.");
			menu(s, dirPath);
		}
		
		System.out.println("Pick from one of the options");
		System.out.println("1) Return the file names in ascending order");
		System.out.println("2) User options");
		System.out.println("3) Exit the program");
		
		int choice = 0;
		
		try {
			choice = s.nextInt();
			s.nextLine();
		}
		catch(InputMismatchException e) {
			System.out.println("The option you chose was not a number");
			System.out.println();
			menu(s, dirPath);
		}
		
		switch(choice) {
		case 1:
			listFiles(s, dirPath);
			break;
		case 2:
			userOptionsMenu(s, dirPath);
			break;
		case 3:
			break;
		default:
			System.out.println("That option was not on the menu, select again.");
			menu(s, dirPath);
			break;
		}
	}
	
	public static void listFiles(Scanner s, File directoryPath) throws IOException {
		 
		 String contents[] = directoryPath.list();
		 
		 Arrays.sort(contents);
		 
		 for(int i = 0; i < contents.length; i++) {
			 System.out.println(contents[i]);
		 }
		 System.out.println();
		
		menu(s, directoryPath);
	}
	
	public static void userOptionsMenu(Scanner s, File dirPath) throws IOException {
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
			userOptionsMenu(s, dirPath);
		}
		
		switch(choice) {
		case 1:
			addFile(s, dirPath);
			break;
		case 2:
			deleteFile(s, dirPath);
			break;
		case 3:
			searchFile(s, dirPath);
			break;
		case 4:
			menu(s, dirPath);
			break;
		default:
			System.out.println("The number chosen was not on the menu, select again.");
			break;
		}
	}
	
	public static void addFile(Scanner s, File dirPath) throws IOException {
		
		System.out.println("What is the name of the file you want to add?");
		String filename = s.nextLine();
		
		if(filename.contains("/"))
			filename = filename.replace("/", "");
		
		String filePath = dirPath.getAbsolutePath();
		
		String newFilepath = filePath + "/" + filename;
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(newFilepath));){
			
		}
		
		System.out.println();
		
		userOptionsMenu(s, dirPath);
	}
	
	public static void deleteFile(Scanner s, File dirPath) throws IOException {
		System.out.println("What is the name of the file you want to delete?");
		String filename = s.nextLine();
		
		if(filename.contains("/"))
			filename = filename.replace("/", "");
		
		String filePath = dirPath.getAbsolutePath();
		
		String newFilepath = filePath + "/" + filename;
		
		try{
			File file = new File(newFilepath);
			file.delete();
		}
		catch(Exception e) {
			System.out.println("There was an " + e + " error with that filename");
		}
		
		System.out.println();
		
		userOptionsMenu(s, dirPath);
	}
	
	public static void searchFile(Scanner s, File dirPath) throws IOException {
		
		System.out.println("What is the name of the file you would like to look for?");
		String filename = s.nextLine();
		
		if(filename.contains("/"))
			filename = filename.replace("/", "");
		
		 File directoryPath = dirPath;
		 
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
		
		userOptionsMenu(s, dirPath);
	}

}
