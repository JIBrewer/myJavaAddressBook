package myAddressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactEntry {
	static Scanner in = new Scanner(System.in);
	static ArrayList<Entry> addressBook = new ArrayList<>();

	public static void main(String[] args) {
		boolean running = true;
		
		while(running) {
		
		int choice = displayMenu();
		
		
		switch(choice) {
			case 1: 
				System.out.println(addEntry());
				break;
				
			case 2: 
				System.out.println(removeEntry());
				break;
				
			case 3: 
				System.out.println(searchEntry());
				break;
				
			case 4: 
				printContent();
				break;
				
			case 5: 
				deleteContent();
				break;
				
			case 6: 
				System.out.println("Thank You");
				running = false;
				break;
				
				default:
					System.out.println("Invalid Entry");
					break;
			}
		
			
		}
		

	}
	
	public static int displayMenu() {
		System.out.println("What would you like to do?");
		
		System.out.println("1. Add an entry");
		System.out.println("2. Remove an entry");
		System.out.println("3. Search for a specific entry");
		System.out.println("4. Print the contents of the address book");
		System.out.println("5. Delete the contents of the address book");
		System.out.println("6. Quit the program");
		int choose = in.nextInt();
		
		return choose;
	}
	
	public static String addEntry() {
		
		System.out.println("What is your fist name?");
		String firstName = in.next();
		
		System.out.println("What is your last name?");
		String lastName = in.next();
		
		System.out.println("What is your phone number");
		String phoneNumber = in.next();
		
		System.out.println("What is your email address");
		String emailAddress = in.next();
		
		Entry newEntry = new Entry(firstName, lastName, phoneNumber, emailAddress);
		addressBook.add(newEntry);
		
		return "New Contact Created: \n" + newEntry.toString();
	}
	
	public static String removeEntry() {
		System.out.println("Enter email address to remove: ");
		String emailInput = in.next();
		
		int i = 0;
		for (Entry entry : addressBook) {
			if (emailInput.equals(entry.getEmailAddress())) {
				addressBook.remove(i);
				return "Address has been deleted. \n" + entry.toString();
			}
			
			i++;
		}
		
		return "Address not found";	
		
	}
	
	public static String searchEntry() {
		System.out.println("Enter your email address.");
		String searchInput = in.next();
		
		for(Entry entry : addressBook) {
			if (searchInput.equals(entry.getEmailAddress())) {
				return "Here are your results. \n" + entry.toString();
			}
			
			
		}
		
		return "Address not found";
	}
	
	public static void printContent() {
		int i = 0;
		
		if (!addressBook.isEmpty()) {
			for (i = 0; i <addressBook.size(); i++) {
				System.out.println(addressBook.get(i));
				
			}
		
		} else {
			System.out.println("Address book is empty");
		}
	}
	
	public static void deleteContent() {
		if (!addressBook.isEmpty()) {
			addressBook.clear();
			System.out.println("The address book has been cleared");
		} else {
			System.out.println("Invalid entry");
		}
	} 
}
