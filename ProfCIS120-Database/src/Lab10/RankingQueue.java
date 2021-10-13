package Lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Dale_Imports.*;
import Lab07.Ranking;



public class RankingQueue extends LinkedUnbndQueue<Ranking> 
{	
	protected int numElements = 0;	// number of elements in this list
	
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
	//Use public methods.... enqueue()/dequeue()
	public String toString() {
		int location = 0;
		Ranking current;
		String str = "";
		while (location < numElements) {
			current = this.dequeue();
			str = str + current.toString();
			this.enqueue(current);
			location++;
		}
		return str;
	}
	// Takes as input userId and removes all rankings from queue with that ID.
	public void removeRater(int userId) {
		// Use Node traversal(getLink and setLink) to move through the queue.

		int numberRemoved = 0;
		LLNode<Ranking> current = this.front;
		LLNode<Ranking> previous = null;

		while (current != null) {
			if (current.getInfo().getUserId() == userId) {
				if (previous == null) {
					front = front.getLink();
					current.setLink(null);
					current = front;
				} else {
				// Delete this entry
					previous.setLink(current.getLink());
					current.setLink(null);
					current = previous;
				}
				// Add to numberRemoved tally
				numberRemoved++;
				numElements--;
			} else { previous = current;}
				
			current = current.getLink();
		}
		// Print out a message saying how many were removed.
		System.out.println(numberRemoved);
	}
}
