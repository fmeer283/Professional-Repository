package Lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dale_Imports.*;

public class RankingHeap extends Heap<Ranking> {
	public RankingHeap(int maxSize) {
		super(maxSize);

	}
	public void fromFile(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner fileContents = new Scanner(inputFile);
			
		for (int i = 0; i < 10; i++) {
			String line = fileContents.nextLine();
			Ranking rankingObject = new Ranking(line);
			this.enqueue(rankingObject);
		}
		System.out.println("First 10 lines. \n" + this + 
				"\n*****************" + "\n*****************");

		this.dequeue();
		System.out.println("1 dequeue " + this + "\n");
		this.dequeue();
		System.out.println("2 dequeue " + this + "\n");
		String line = fileContents.nextLine();
		Ranking rankingObject = new Ranking(line);
		this.enqueue(rankingObject);
		System.out.println("2 dequeue and 1 enqueue " + this + "\n");;
		line = fileContents.nextLine();
		rankingObject = new Ranking(line);
		this.enqueue(rankingObject);

		System.out.println("2 dequeues and 2 enqueues. \n" + this + 
				"\n*****************" + "\n*****************");
		fileContents.close();
	}
	
}
