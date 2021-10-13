package Lab11;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class JunitTest {

	@Test
//	public void testRankingBST() throws FileNotFoundException{
//		RankingBST testRankingBST = new RankingBST("u.data");
//		
//		System.out.print(testRankingBST.userOccurences(119) +"\n");
//		System.out.print(testRankingBST.userOccurences(303) +"\n");
//		System.out.print(testRankingBST.userOccurences(546) +"\n");
//		System.out.print(testRankingBST.userOccurences(1000) +"\n");
//	}
	public void testRankingHeap() throws FileNotFoundException{
		RankingHeap testRankingHeap = new RankingHeap(10);
		testRankingHeap.fromFile("u.data");
	}
}
