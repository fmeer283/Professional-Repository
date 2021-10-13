package Lab08;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void test() throws FileNotFoundException{
		RankingQueue testRankingQueue = new RankingQueue();
		testRankingQueue.fromFile("u.data");
	
		testRankingQueue.removeRater(196);
		//testRankingQueue.toString();
		//System.out.println(testRankingQueue.toString());
	}

}
