package Lab10;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import Dale_Imports.*;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void test() throws FileNotFoundException {
		// Initial queue to hold all of the data		
		QueueLibrary queueLibrary = new QueueLibrary("u.data");
		
//		// Made after the fact purely to test and show results for compareTo
//		// and equals classes
//		Ranking rankingTest1 = new Ranking();
//		Ranking rankingTest2 = new Ranking();
//		// To traverse the queue and test specific rankings
//		for (int i = 0; i < 1; i++) {
//			rankingTest1 = queueLibrary.dequeue();
//			queueLibrary.enqueue(rankingTest1);
//		}
//		for (int i = 0; i < 13733; i++) {
//			rankingTest2 = queueLibrary.dequeue();
//			queueLibrary.enqueue(rankingTest2);
//		}
//		System.out.println(rankingTest1.compareTo(rankingTest2));
//		System.out.println(rankingTest1.equals(rankingTest2));
		
		int numElements = queueLibrary.getNumElements();
		
		// Instantiate all of the data structures
		ArrayUnsortedList<Ranking> arrayUnsortedList = new ArrayUnsortedList<Ranking>();
		ArraySortedList<Ranking> arraySortedList = new ArraySortedList<Ranking>();
		ArraySortedList2<Ranking> arraySortedList2 = new ArraySortedList2<Ranking>();
		ArraySortedList3<Ranking> arraySortedList3 = new ArraySortedList3<Ranking>();
		RefUnsortedList<Ranking> refUnsortedList = new RefUnsortedList<Ranking>();
		RefSortedList<Ranking> refSortedList = new RefSortedList<Ranking>();
		BinarySearchTree<Ranking> binarySearchTree = new BinarySearchTree<Ranking>();
		
		// Instantiate the arrayIndexedList to test the contains method
		ArrayIndexedList<Ranking> arrayIndexedListRandom = new ArrayIndexedList<Ranking>();
		
//		*************************************
//		Timing the Building of Each Structure
		System.out.println("Build times for these various data structures"
				+ " to include " + numElements + " \nelements into their "
				+ "structure.\n\nTime is recorded in seconds.\n");
				
//		ArrayUnsortedList
		System.out.println("ArrayUnsortedList: " + 
				queueLibrary.toListDataStructure(arrayUnsortedList) + " seconds\n");
		
//		ArraySortedList
		System.out.println("ArraySortedList: " + 
				queueLibrary.toListDataStructure(arraySortedList) + " seconds\n");
		
//		ArraySortedList2
		System.out.println("ArraySortedList2: " + 
				queueLibrary.toListDataStructure(arraySortedList2) + " seconds\n");
		
//		ArraySortedList3
		System.out.println("ArraySortedList3: " + 
				queueLibrary.toListDataStructure(arraySortedList3) + " seconds\n");
		
//		RefUnsortedList
		System.out.println("RefUnsortedList: " + 
				queueLibrary.toListDataStructure(refUnsortedList) + " seconds\n");
		
//		RefSortedList
		System.out.println("RefSortedList: " + 
				queueLibrary.toListDataStructure(refSortedList) + " seconds\n");
		
//		BinarySearchTree
		System.out.println("BinarySearchTree: " + 
				queueLibrary.toBstDataStructure(binarySearchTree) + " seconds\n");
		
//		*************************************
//		Timing the Search of Each Structure
		System.out.println("Search through times for these various data structures"
				+ ("Searching for 10 items in a heap of " + numElements));
//		Randomized queue is created
		queueLibrary.toArrayIndexedListRandomizer(arrayIndexedListRandom);
//		Timing the Search through of Each Structure
//		ArrayUnsortedList
		System.out.println("\nArrayUnsortedList: \n" + queueLibrary.containsCaller
				(arrayUnsortedList, arrayIndexedListRandom));
//		ArraySortedList
		System.out.println("\nArraySortedList: " + queueLibrary.containsCaller
				(arraySortedList, arrayIndexedListRandom));
//		ArraySortedList2
		System.out.println("\nArraySortedList2: " + queueLibrary.containsCaller
				(arraySortedList2, arrayIndexedListRandom));
//		ArraySortedList3
		System.out.println("\nArraySortedList3: " + queueLibrary.containsCaller
				(arraySortedList3, arrayIndexedListRandom));
//		RefUnsortedList
		System.out.println("\nRefUnsortedList: " + queueLibrary.containsCaller
				(refUnsortedList, arrayIndexedListRandom));
//		RefSortedList
		System.out.println("\nRefSortedList: " + queueLibrary.containsCaller
				(refSortedList, arrayIndexedListRandom));
//		BinarySearchTree		
		System.out.println("\nBinarySearchTree: " + queueLibrary.containsCallerBST
				(binarySearchTree, arrayIndexedListRandom));

	}		
}
