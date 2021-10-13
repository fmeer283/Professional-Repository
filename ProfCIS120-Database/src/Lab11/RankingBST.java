package Lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dale_Imports.*;

public class RankingBST extends BinarySearchTree<Ranking> {
	
	protected int numElements = 0;
	
	public RankingBST() {}
	public RankingBST(String fileName)throws FileNotFoundException {
		this.fromFile(fileName);
	}
	public void fromFile(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner fileContents = new Scanner(inputFile);
			
		while (fileContents.hasNextLine()) {
			String line = fileContents.nextLine();
			Ranking rankingObject = new Ranking(line);
			this.add(rankingObject);
			numElements++;
		}
		fileContents.close();
	}
	
	  private int recUserOccurences(int userId, BSTNode<Ranking> tree)
//	  Counts how many times a particular user appears in the BST
	  {
		int quanOccur = 0;
	    if (tree == null)
	      return 0;       // userId does not match
	    else if (tree.getInfo().getUserId() == userId)
	    	quanOccur++;  // userId is match

	    quanOccur = quanOccur + recUserOccurences(userId, tree.getLeft()) 
			+ recUserOccurences(userId, tree.getRight());
	    
	      return quanOccur;         
	  }

	  public int userOccurences (int userId)
//	  Counts how many times a particular user appears in the BST
	  {
	    return recUserOccurences(userId, root);
	  }
}
