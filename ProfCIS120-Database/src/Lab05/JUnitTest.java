package Lab05;

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
		
		RankingStack newRankingsStack = new RankingStack();
		
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Ranking newMovie = new Ranking(line);
			 newRankingsStack.push(newMovie);
		}
		fileContents.close();
		
		//System.out.println(newRankingsStack.toString());
		
		System.out.println("How Many Ratings of 2: " + newRankingsStack.wrapper(2) + "\n");
		System.out.println("How Many Ratings of 3: " + newRankingsStack.wrapper(3) + "\n");
		System.out.println("How Many Ratings of 4: " + newRankingsStack.wrapper(4) + "\n");
	}

}
