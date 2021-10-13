package EXPERIMENTAL_SANDBOX;
import Dale_Imports.*;


public class MAIN {

	public static void main(String[] args) {
	
//		ListInterface<String> list = new RefSortedList<String>();
//		list.add("apple");
//		list.add("peach");
//		list.add("orange");
//		list.add("pear");
//		list.add();
//		list.remove("peach");
//		
//		System.out.println(list);
		
		
		// BST
//		BinarySearchTree<Golfer> golferTree = 
//				new BinarySearchTree<Golfer>();
		Golfer golf1 = new Golfer("fred", 15);
		Golfer golf2 = new Golfer("bro", 21);
		Golfer golf3 = new Golfer("another bro", 25);
		Golfer golf4 = new Golfer("fred", 15);
		Golfer golf5 = new Golfer("fred", 15);
//		golferTree.add(golf1);
//		golferTree.add(golf2);
//		golferTree.add(golf3);
//		golferTree.add(golf4);
//		golferTree.add(golf5);
//		golferTree.size();
//		System.out.println( golferTree.countLess2(golf4));
		PriQueueInterface<Golfer> golferList = new ArraySortedList<Golfer>();
	}
//	public static int countLess(BinarySearchTree<Golfer> tree, 
//			Golfer maxValue) {
//		tree.reset(1);
//		int numElements = tree.size();
//		int number = 0;
//		
//		int compareValue = maxValue.getScore();
//		
//		for(int i = 0; i < numElements; i++) {
//			if(compareValue >= tree.getNext(1).getScore()) {
//				number++;
//			}
//
//		}
//		return number;		
//	}
}
