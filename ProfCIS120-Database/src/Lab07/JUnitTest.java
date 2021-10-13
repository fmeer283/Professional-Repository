package Lab07;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;

public class JUnitTest {

	@Test
	public void test()throws FileNotFoundException {
		MovieLibrary testMovieLibrary = new MovieLibrary();
		testMovieLibrary.fromFile("u.item");
		
		RankingQueue testRankingQueue = new RankingQueue();
		testRankingQueue.fromFile("u.data");
		
		//System.out.println(testMovieLibrary.findType("comedy").toString());
		System.out.println(testRankingQueue.movieAvgRating(50));
		//System.out.println(testRankingQueue.findGoodType(testMovieLibrary, "animation", 2.0));
	}
	@Test 
	public void findGoodType_animation2_ToyStory()throws FileNotFoundException {
		MovieLibrary testMovieLibrary = new MovieLibrary();
		testMovieLibrary.fromFile("u.item");
		
		RankingQueue testRankingQueue = new RankingQueue();
		testRankingQueue.fromFile("u.data");
		var goodType = testRankingQueue.findGoodType(testMovieLibrary, "sci-Fi", 4.3);
		
		//assertEquals(goodType.top().movieName, "Toy Story (1995)");
		
		System.out.println(goodType);
	}
	/*Movie: 
		Id: 1
		Name: Toy Story (1995)
		Released: 01-Jan-1995
		Video Released: 
		Type: animation
		Type: childrens
		Type: comedy*/
}
