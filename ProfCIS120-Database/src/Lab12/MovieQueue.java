package Lab12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;


public class MovieQueue extends LinkedTransferQueue<Movie> {
	
	public MovieQueue() {}
	public MovieQueue(String fileName)throws FileNotFoundException {
		this.fromFile(fileName);
	}
	public void fromFile(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner fileContents = new Scanner(inputFile);
			
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Movie movieObject = new Movie(line);
			this.put(movieObject);
		}
		fileContents.close();
	}
	public MovieQueue findType(String type) {

		MovieQueue searchResults = new MovieQueue();
		//Use iterator
		Iterator<Movie> iteration = this.iterator();

		while (iteration.hasNext()) {
			Movie movie = iteration.next();

			for (int i = 0; i < movie.isThisMovieType.length; i++) {
				if (type.equals(movie.isThisMovieType[i])) {
					searchResults.put(movie);
					break;
				}
			}
		}
		if (searchResults.isEmpty()) {
			System.out.println("The search did not find any movies of this type. "
					+ "\nMake sure your input is a valid movie type\n");
		}
		System.out.println("SearchResults: " + searchResults.size() + "\n");
		
		return searchResults;
	}
}
