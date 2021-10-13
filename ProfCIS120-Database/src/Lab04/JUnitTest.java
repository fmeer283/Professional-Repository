package Lab04;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void test() throws FileNotFoundException {
		File inputFile = new File("u.data");
		Scanner fileContents = new Scanner(inputFile);
		
		StringLogInterface userId = new LinkedStringLog("userId");
		StringLogInterface movieId = new LinkedStringLog("movieId");
		StringLogInterface movieRating = new LinkedStringLog("movieRating");
		StringLogInterface timeStamp = new LinkedStringLog("timeStamp");
		
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			String[] tokens = line.split("\\s");

			userId.insert(tokens[0]);
			movieId.insert(tokens[1]);
			movieRating.insert(tokens[2]);
			timeStamp.insert(tokens[3]);
		}
		fileContents.close();
		
		System.out.println(userId.howMany("22"));
		System.out.println(movieId.howMany("346"));
		System.out.println(movieRating.howMany("1"));
		System.out.println(timeStamp.howMany("886397596"));
	}
}
