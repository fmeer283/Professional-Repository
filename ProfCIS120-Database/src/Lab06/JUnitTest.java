package Lab06;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void test()throws FileNotFoundException {
		MovieLibrary newMovieLibrary = new MovieLibrary();
		newMovieLibrary.fromFile("u.item");
		
		System.out.println(newMovieLibrary.toString());
		
		//System.out.println(newMovieLibrary.findInLibrary("Toy Story (1995)"));
	}
}
