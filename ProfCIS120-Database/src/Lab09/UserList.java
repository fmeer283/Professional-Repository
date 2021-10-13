package Lab09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dale_Imports.*;

public class UserList extends RefUnsortedList<User> {
	
	public UserList() {
		super();

	}
	public void fromTextFile(String fileName) throws FileNotFoundException {
		// Reads the entire file into the list structure
		File inputFile = new File(fileName);
		Scanner fileContents = new Scanner(inputFile);
		
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			User singleUser = new User(line);
			
			this.add(singleUser);
		}
		fileContents.close();
	}
	public String findUserId(int id) {
		String aUserById = "";
		Boolean found = false;
		// Finds  1 user in list with userID.
		this.reset();
		// ??? Is this zero indexed????
		for(int i = 0; i < this.numElements; i++) {
			if (id == this.currentPos.getInfo().getId()) {
				aUserById = this.currentPos.getInfo().toString();
				found = true;
				break;
			} else {
				this.getNext();
			}
		}
		// Returns "not found" message if none exists.
		if (found == false) {
			aUserById = "User not found";
		}
		return aUserById;
	}
	public UserList findOccupation(String occ) {
		UserList listOfUsersByOccupation = new UserList();
		User currentUser = new User();
		Boolean isEmpty = true;
		// Finds all users in list with this occupation.
		this.reset();
		for(int i = 0; i < this.numElements; i++) {
			currentUser = this.currentPos.getInfo();
			if (occ.equalsIgnoreCase(currentUser.getOccupation())) {
				listOfUsersByOccupation.add(currentUser);
				isEmpty = false;
				this.getNext();
			} else {
				this.getNext();
			}
		}
		if (isEmpty == true) {
			System.out.println("This List is Empty");
		}
		// Returns empty list if none exists.
		// Public methods only (reset()/getNext()).
		return listOfUsersByOccupation;
	}
	public UserList findZipCode(String zip) {
		UserList listOfUsersByZipCode = new UserList();
		User currentUser = new User();
		Boolean isEmpty = true;
		// Finds all users in list with this zip code.
		this.reset();
		for(int i = 0; i < this.numElements; i++) {
			currentUser = this.currentPos.getInfo();
			if (zip.equalsIgnoreCase(currentUser.getZipCode())) {
				listOfUsersByZipCode.add(currentUser);
				isEmpty = false;
				this.getNext();
			} else {
				this.getNext();
			}
		}
		if (isEmpty == true) {
			System.out.println("This List is Empty");
		}
		// Returns empty list if none exists.
		// Public methods only (reset()/getNext()).
		return listOfUsersByZipCode;
	}
}
