package Lab03;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class JUnitTest {
	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = new File("ushort");
		Scanner fileContents = new Scanner(inputFile);
		
		StringLogInterface userId = new ArrayStringLog("User ID", 100000);
		StringLogInterface movieId = new ArrayStringLog("Movie ID", 100000);
		StringLogInterface movieRating = new ArrayStringLog("Movie Rating", 100000);
		StringLogInterface timeStamp = new ArrayStringLog("Time Stamp", 100000);
		
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Ranking newMovie = new Ranking(line);
			userId.insert(newMovie.getUserId());
			movieId.insert(newMovie.getMovieId());
			movieRating.insert(newMovie.getMovieRating());
			timeStamp.insert(newMovie.getTimeStamp());
		}
		fileContents.close();
		
		System.out.println(userId);
		//System.out.println("Number of times that user 299 rated movies: " + userId.howMany("299"));
		System.out.println(movieId);
		//System.out.println("Number of times that movie 51 was rated: " + movieId.howMany("51"));
		System.out.println(movieRating);
		//System.out.println("Number of times a rating of '3' was given: " + movieRating.howMany("3"));
		System.out.println(timeStamp);
		
		
	}
}
