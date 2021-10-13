package Lab12;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void testMovieQueueFindType() throws FileNotFoundException {
		MovieQueue testMovieQueue = new MovieQueue("u.item");
		System.out.println(testMovieQueue.findType("bah"));
	}

}
