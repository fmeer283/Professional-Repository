package Lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MovieMain {

	public static void main(String[] args) throws FileNotFoundException {
		
		File inputFile = new File("uitemshort");
		Scanner fileContents = new Scanner(inputFile);
		String line = fileContents.nextLine();
		// TODO while loop to read next line
		Movie newMovie1 = new Movie(line);
		fileContents.close();

		System.out.println(newMovie1.toString());
	}
}
