package Lab09;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void testUserList() throws FileNotFoundException {

			UserList ListOfUsers = new UserList();
			ListOfUsers.fromTextFile("u.user");
			

			//System.out.println(ListOfUsers);
			//System.out.println(ListOfUsers.findUserId(10));
			//System.out.println(ListOfUsers.findOccupation("mm"));
			System.out.println(ListOfUsers.findZipCode("90703"));
			
	}
//	@Test
//	public void testUserSerSave() throws IOException {
//		File inputFile = new File("u.user");
//		Scanner fileContents = new Scanner(inputFile);
//		String line = fileContents.nextLine();
//		fileContents.close();
//		UserSer userToSer = new UserSer(line);
//		
//		userToSer.toSerFile("UserSerFiles");
//		System.out.println(userToSer);
//	}
//	@Test
//	public void testUserSerRead() throws IOException {
//		UserSer diffUser = new UserSer();
//		
//		diffUser.fromSerFile("UserSerFiles");
//		System.out.println(diffUser);
//	}
}
