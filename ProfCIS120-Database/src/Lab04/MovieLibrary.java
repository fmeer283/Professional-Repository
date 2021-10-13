package Lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dale_Imports.*;


public class MovieLibrary {

	public static void main(String[] args) throws FileNotFoundException {
		
		File inputFile = new File("u.item");
		Scanner fileContents = new Scanner(inputFile);
		
		BoundedStackInterface<Movie> currentStack = new ArrayStack<Movie>(100000000);
		
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Movie newMovie = new Movie(line);
			currentStack.push(newMovie);
		}
		fileContents.close();
		// Currently, the date is apart of the name and must be included.
		System.out.println(find(currentStack, "blah"));
	}
	
	public static Movie find(BoundedStackInterface<Movie> element, String searchElement)
	{       
			Movie currentMovie = new Movie();
			BoundedStackInterface<Movie> tempStack = new ArrayStack<Movie>(100000000);
		    while (!element.isEmpty()) 
		    {
		    	currentMovie = element.top();
		    	tempStack.push(element.top());
		    	element.pop();
		    	
		    	if (searchElement.equalsIgnoreCase(currentMovie.getMovieName()))  // if they match
		    		break;
		    	else if (element.isEmpty())
		    		return currentMovie = null;
		    }
		    while (!tempStack.isEmpty())
		    {
		    	element.push(tempStack.top());
		    	tempStack.pop();
		    }
		    return currentMovie;
	}
}
