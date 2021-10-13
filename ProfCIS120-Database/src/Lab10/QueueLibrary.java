package Lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Dale_Imports.*;

public class QueueLibrary extends ArrayUnbndQueue<Ranking> {
	
	protected int numElements = 0;	// number of elements in this list

	public QueueLibrary() {}
	
	public QueueLibrary(String fileName) throws FileNotFoundException{
		this.fromFile(fileName);
	}
	public void fromFile(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner fileContents = new Scanner(inputFile);
			
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Ranking rankingObject = new Ranking(line);
			this.enqueue(rankingObject);
			numElements++;
		}
		fileContents.close();
	}


	public Double toListDataStructure(ListInterface<Ranking> object) {
		Long startTime = System.nanoTime();
		
		for (int i = 0; i < numElements; i++) {
			Ranking rankingObject = this.dequeue();
			object.add(rankingObject);
			this.enqueue(rankingObject);
		}
		Long estimatedTime = System.nanoTime() - startTime;
		Double estimatedTimeAsDouble = (double) estimatedTime/1000000000;
		return estimatedTimeAsDouble;
	}
	public Double toBstDataStructure(BSTInterface<Ranking> object) {
		Long startTime = System.nanoTime();
		
		for (int i = 0; i < numElements; i++) {
			Ranking rankingObject = this.dequeue();
			object.add(rankingObject);
			this.enqueue(rankingObject);
		}
		Long estimatedTime = System.nanoTime() - startTime;
		Double estimatedTimeAsDouble = (double) estimatedTime/1000000000;
		return estimatedTimeAsDouble;
	}
	public void toArrayIndexedListRandomizer(ArrayUnsortedList<Ranking> Ten_R_Elements) {

		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			int randomizer = random.nextInt((100000 - 1) + 1);
//			Looks for the item in the Queue that corresponds 
//			to the randomizer then throws it into the ArrayIndexedList
			for (int j = 0; j < numElements; j++) {
				if (j == randomizer) {
					Ranking ranRanking = this.dequeue();
					Ten_R_Elements.add(ranRanking);
					this.enqueue(ranRanking);
				}else {
					this.enqueue(this.dequeue());
				}
			}
		}
	}
	public Double containsCaller(ListInterface<Ranking> object, ArrayIndexedList<Ranking> compareToObject) {
		Long startTime = System.nanoTime();
		boolean[] boolArray = new boolean[10];
		// Utilizes boolean array for future functionality
		for (int i = 0; i < 10; i++) {
			boolArray[i] = object.contains(compareToObject.get(i));
			System.out.println(boolArray[i]);
		}
		Long estimatedTime = System.nanoTime() - startTime;
		Double estimatedTimeAsDouble = (double) estimatedTime/1000000000;
		return estimatedTimeAsDouble;
	}
	public Double containsCallerBST(BSTInterface<Ranking> object, ArrayIndexedList<Ranking> compareToObject) {
		Long startTime = System.nanoTime();
		boolean[] boolArray = new boolean[10];
		// Utilizes boolean array for future functionality
		for (int i = 0; i < 10; i++) {
			boolArray[i] = object.contains(compareToObject.get(i));
			System.out.println(boolArray[i]);
		}
		Long estimatedTime = System.nanoTime() - startTime;
		Double estimatedTimeAsDouble = (double) estimatedTime/1000000000;
		return estimatedTimeAsDouble;
	}
//	Getters/Setters
	public int getNumElements() {
		return numElements;
	}

	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}
}
