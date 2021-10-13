package Lab07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Dale_Imports.*;


public class MovieLibrary extends LinkedStack<Movie> {
	
	public void fromFile(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner fileContents = new Scanner(inputFile);
			
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Movie newMovie = new Movie(line);
			this.push(newMovie);
		}
		fileContents.close();
	}
	
	public MovieLibrary findType(String type) {
		// Linked node traversal
		// Check input to make sure it is a valid type
		MovieLibrary collectionOfType = new MovieLibrary();
		MovieLibrary stackHolder = new MovieLibrary();
		//System.out.println(this);
		while (!this.isEmpty()) {
			Movie current = this.top();
			for (int i = 0; i < current.isThisMovieType.length; i++) {
				if (type.equals(current.isThisMovieType[i])) {
					collectionOfType.push(current);
					stackHolder.push(current);
					break;
				}
			}
			stackHolder.push(current);
			this.pop();
		}
		// Restore original stack
		while (!stackHolder.isEmpty()) {
			this.push(stackHolder.top());
			stackHolder.pop();
		}
		
		return collectionOfType;
	}

	public boolean findInLibrary(String movieName) {
		boolean isMovieHere = inLibrary(movieName, top);

		return isMovieHere;
	}
	protected boolean inLibrary(String movieName, LLNode<Movie> current) {
		//.contains() so that the year is not included in the movie title
		boolean isMovieHere = false;
		if (current == null) {
			return false;
		}
		if (current.getInfo().getMovieName().equalsIgnoreCase(movieName)) {
			return isMovieHere = true;
		}
		else if (current.getInfo().getMovieName().contains(movieName) && !isMovieHere) {
			System.out.println(current.getInfo().getMovieName());
		}
		if (this.inLibrary(movieName, current.getLink()))
			isMovieHere = true;
			
		return isMovieHere;
	}
	
	public String toString() {
		LLNode<Movie> current = top;
		String str = "";
		while (current != null) {
			str = str + current.getInfo().toString();
			current = current.getLink();
		}
		return str;
	}
}