package Lab14;

//----------------------------------------------------------------------------
// Sorts.java               by Dale/Joyce/Weems                     Chapter 10
//
// Test harness used to run sorting algorithms.
//----------------------------------------------------------------------------

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Sorts
{ 
  static int maxSize = 100000;						  // sets the length of the array
  static int[] master = new int[maxSize];   				 	  // Master array of values to be sorted
  static int[] copyOfValues;				  // a clone of the master array
  static int lastIndex = -1;
  static int size;	  // size of array to be sorted
  
public Sorts(int maxSize)
  // Precondition:   maxSize > 0
  // Added this to initialize my own array
  {
    master = new int[maxSize];

  }
  static void insert(int element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into the values array.
  {      
    lastIndex++;
    master[lastIndex] = element;
  }
  static void reset() 
  {
	  copyOfValues = master.clone();
	  size = copyOfValues.length;
  }

  static public boolean isSorted()
  // Returns true if the array values are sorted and false otherwise.
  {
    boolean sorted = true;
    for (int index = 0; index < (size - 1); index++)
      if (copyOfValues[index] > copyOfValues[index + 1])
        sorted = false;
    return sorted;
  }

  static public void swap(int index1, int index2)
  // Precondition: index1 and index2 are >= 0 and < SIZE.
  //
  // Swaps the integers at locations index1 and index2 of the values array. 
  {
    int temp = copyOfValues[index1];
    copyOfValues[index1] = copyOfValues[index2];
    copyOfValues[index2] = temp;
  }
  static public void printMasterValues()
  // Prints all the values integers.
  {
    int value;
    DecimalFormat fmt = new DecimalFormat("00");
    System.out.println("The master array is:");
    for (int index = 0; index < 5; index++)
    {
      value = master[index];
      if (((index + 1) % 10) == 0)
        System.out.println(fmt.format(value));
      else
        System.out.print(fmt.format(value) + " ");
    }
    System.out.println("\n");
  }
  static public void printCopyOfValues()
  // Prints all the copyOfValues integers.
  {
    int value;
    DecimalFormat fmt = new DecimalFormat("00");
    System.out.println("The copy to be sorted is currently:");
    for (int index = 0; index < 5; index++)
    {
      value = copyOfValues[index];
      if (((index + 1) % 10) == 0)
        System.out.println(fmt.format(value));
      else
        System.out.print(fmt.format(value) + " ");
    }
    System.out.println("\n");
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Selection Sort

  static int minIndex(int startIndex, int endIndex)
  // Returns the index of the smallest value in
  // values[startIndex]..values[endIndex].
  {
    int indexOfMin = startIndex;
    for (int index = startIndex + 1; index <= endIndex; index++)
      if (copyOfValues[index] < copyOfValues[indexOfMin])
        indexOfMin = index;
    return indexOfMin;
  }

  static void selectionSort()
  // Sorts the values array using the selection sort algorithm.
  {
    int endIndex = size - 1;
    for (int current = 0; current < endIndex; current++)
      swap(current, minIndex(current, endIndex));
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Bubble Sort

  static void bubbleUp(int startIndex, int endIndex)
  // Switches adjacent pairs that are out of order 
  // between values[startIndex]..values[endIndex] 
  // beginning at values[endIndex].
  {
    for (int index = endIndex; index > startIndex; index--)
      if (copyOfValues[index] < copyOfValues[index - 1])
        swap(index, index - 1);
  }
 
  static void bubbleSort()
  // Sorts the values array using the bubble sort algorithm.
  {
    int current = 0;
 
    while (current < (size - 1))
    {
      bubbleUp(current, size - 1);
      current++;
    }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Short Bubble Sort

  static boolean bubbleUp2(int startIndex, int endIndex)
  // Switches adjacent pairs that are out of order 
  // between values[startIndex]..values[endIndex] 
  // beginning at values[endIndex].
  //
  // Returns false if a swap was made; otherwise, returns true.
  {
    boolean sorted = true;
    for (int index = endIndex; index > startIndex; index--)
      if (copyOfValues[index] < copyOfValues[index - 1])
      {
        swap(index, index - 1);
        sorted = false;
      }
    return sorted;
  }
 
  static void shortBubble()
  // Sorts the values array using the bubble sort algorithm.
  // The process stops as soon as values is sorted.
  {
    int current = 0;
    boolean sorted = false;
    while ((current < (size - 1)) && !sorted)
    {
      sorted = bubbleUp2(current, size - 1);
      current++;
    }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Insertion Sort

  static void insertItem(int startIndex, int endIndex)
  // Upon completion, values[0]..values[endIndex] are sorted.
  {
    boolean finished = false;
    int current = endIndex;
    boolean moreToSearch = true;
    while (moreToSearch && !finished)
    {
      if (copyOfValues[current] < copyOfValues[current - 1])
      {
        swap(current, current - 1);
        current--;
        moreToSearch = (current != startIndex);
      }
      else
        finished = true;
    }
  }
 
  static void insertionSort()
  // Sorts the values array using the insertion sort algorithm.
  {
   for (int count = 1; count < size; count++)
      insertItem(0, count);
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Merge Sort

  static void merge (int leftFirst, int leftLast, int rightFirst, int rightLast)
  // Preconditions: values[leftFirst]..values[leftLast] are sorted.
  //                values[rightFirst]..values[rightLast] are sorted.
  // 
  // Sorts values[leftFirst]..values[rightLast] by merging the two subarrays.
  {
    int[] tempArray = new int [size];
    int index = leftFirst;
    int saveFirst = leftFirst;  // to remember where to copy back
 
    while ((leftFirst <= leftLast) && (rightFirst <= rightLast))
    {
      if (copyOfValues[leftFirst] < copyOfValues[rightFirst])
      {
        tempArray[index] = copyOfValues[leftFirst];
        leftFirst++;
      }
      else
      {
        tempArray[index] = copyOfValues[rightFirst];
        rightFirst++;
      }
      index++;
    }
 
    while (leftFirst <= leftLast)
    // Copy remaining items from left half.
 
    {
      tempArray[index] = copyOfValues[leftFirst];
      leftFirst++;
      index++;
    }
 
    while (rightFirst <= rightLast)
    // Copy remaining items from right half.
    {
      tempArray[index] = copyOfValues[rightFirst];
      rightFirst++;
      index++;
    }
 
    for (index = saveFirst; index <= rightLast; index++)
    	copyOfValues[index] = tempArray[index];
  }

  static void mergeSort(int first, int last)
  // Sorts the values array using the merge sort algorithm.
  {
    if (first < last)
    {
      int middle = (first + last) / 2;
      mergeSort(first, middle);
      mergeSort(middle + 1, last);
      merge(first, middle, middle + 1, last);
    }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Quick Sort

  static int split(int first, int last)
  {
    int splitVal = copyOfValues[first];
    int saveF = first;
    boolean onCorrectSide;
 
    first++;
    do
    {
      onCorrectSide = true;
      while (onCorrectSide)             // move first toward last
        if (copyOfValues[first] > splitVal)
          onCorrectSide = false;
        else
        {
          first++;
          onCorrectSide = (first <= last);
        }
 
      onCorrectSide = (first <= last);
      while (onCorrectSide)             // move last toward first
        if (copyOfValues[last] <= splitVal)
          onCorrectSide = false;
        else
         {
          last--;
          onCorrectSide = (first <= last);
         }
   
      if (first < last)                
      {
        swap(first, last);
        first++;
        last--;
      }
    } while (first <= last);
 
    swap(saveF, last);
    return last;
  }

  static void quickSort(int first, int last)
  {
    if (first < last)
    {
      int splitPoint;
 
      splitPoint = split(first, last);
      // values[first]..values[splitPoint - 1] <= splitVal
      // values[splitPoint] = splitVal
      // values[splitPoint+1]..values[last] > splitVal
 
      quickSort(first, splitPoint - 1);
      quickSort(splitPoint + 1, last);
    }
  }


  /////////////////////////////////////////////////////////////////
  //
  //  Heap Sort

  static int newHole(int hole, int lastIndex, int item)
  // If either child of hole is larger than item this returns the index
  // of the larger child; otherwise it returns the index of hole.
  {
    int left = (hole * 2) + 1;
    int right = (hole * 2) + 2;
    if (left > lastIndex)
      // hole has no children
      return hole;         
    else
    if (left == lastIndex)
      // hole has left child only
      if (item < copyOfValues[left])             
        // item < left child
        return left;
      else
        // item >= left child
        return hole;
    else
    // hole has two children 
    if (copyOfValues[left] < copyOfValues[right])
      // left child < right child
      if (copyOfValues[right] <= item)
        // right child <= item
        return hole;
      else
        // item < right child
        return right;
    else
    // left child >= right child
    if (copyOfValues[left] <= item)
      // left child <= item
      return hole;
    else
      // item < left child
      return left;
  }

  static void reheapDown(int item, int root, int lastIndex)
  // Precondition: Current root position is "empty".
  //
  // Inserts item into the tree and ensures shape and order properties.
  {
    int hole = root;   // current index of hole
    int newhole;       // index where hole should move to

    newhole = newHole(hole, lastIndex, item);   // find next hole
    while (newhole != hole)
    {
      copyOfValues[hole] = copyOfValues[newhole];      // move value up
      hole = newhole;                      // move hole down
      newhole = newHole(hole, lastIndex, item);     // find next hole
    }
    copyOfValues[hole] = item;           // fill in the final hole
  }

  static void heapSort()
  // Sorts the values array using the heap sort algorithm.
  {
    int index;
    // Convert the array of values into a heap.
    for (index = size/2 - 1; index >= 0; index--)
      reheapDown(copyOfValues[index], index, size - 1);
 
    // Sort the array.
    for (index = size - 1; index >=1; index--)
    {
      swap(0, index);
      reheapDown(copyOfValues[0], 0, index - 1);
    }
  }

  /////////////////////////////////////////////////////////////////
  //
  //  Main

  public static void main(String[] args) throws FileNotFoundException
  {
	File inputFile = new File("u.data");
	Scanner fileContents = new Scanner(inputFile);
		
	while (fileContents.hasNextLine()) {
		String line = fileContents.nextLine();
		String[] tokens = line.split("\\s");
		
		Sorts.insert(Integer.parseInt(tokens[3]));
	}
	fileContents.close();
	
	// Start
	reset();
	printMasterValues();
	printCopyOfValues();
    System.out.println("values are sorted: " + isSorted() + "\n");
	
    Long selectionSortStartTime = System.nanoTime();
    selectionSort();
    Long selectionSortEstimatedTime = System.nanoTime() - selectionSortStartTime;
    System.out.println("AFTER SORT: ");
    printCopyOfValues();
    System.out.println("values are sorted by selectionSort: " + isSorted() + "\n");
    
	reset();
	printCopyOfValues();
	Long bubbleSortStartTime = System.nanoTime();
    bubbleSort();
    Long bubbleSortEstimatedTime = System.nanoTime() - bubbleSortStartTime;
    System.out.println("AFTER SORT: ");
    printCopyOfValues();
    System.out.println("values are sorted by bubbleSort: " + isSorted() + "\n");
    
    reset();
    printCopyOfValues();
    Long shortBubbleStartTime = System.nanoTime();
    shortBubble();
    Long shortBubbleEstimatedTime = System.nanoTime() - shortBubbleStartTime;
    System.out.println("AFTER SORT: ");
    printCopyOfValues();
    System.out.println("values are sorted by shortBubble: " + isSorted() + "\n");
    
    reset();
    printCopyOfValues();
    Long insertionSortStartTime = System.nanoTime();
    insertionSort();
    Long insertionSortEstimatedTime = System.nanoTime() - insertionSortStartTime;
    System.out.println("AFTER SORT: ");
    printCopyOfValues();
    System.out.println("values are sorted by insertionSort: " + isSorted() + "\n");
    
    reset();
    printCopyOfValues();
    Long mergeSortStartTime = System.nanoTime();
    mergeSort(0, size - 1);
    Long mergeSortEstimatedTime = System.nanoTime() - mergeSortStartTime;
    System.out.println("AFTER SORT: ");
    printCopyOfValues();
    System.out.println("values are sorted by mergeSort: " + isSorted() + "\n");
    
    reset();
    printCopyOfValues();
	Long quickSortStartTime = System.nanoTime();
    quickSort(0, size - 1);
    Long quickSortEstimatedTime = System.nanoTime() - quickSortStartTime;
    System.out.println("AFTER SORT: ");
    printCopyOfValues();
    System.out.println("values are sorted by quickSort: " + isSorted() + "\n");
	
    reset();
    printCopyOfValues();
    Long heapSortStartTime = System.nanoTime();
    heapSort();
    Long heapSortEstimatedTime = System.nanoTime() - heapSortStartTime;
    System.out.println("AFTER SORT: ");
    printCopyOfValues();
    System.out.println("values are sorted by heapSort: " + isSorted() + "\n");
    
    
    System.out.println("SORTING METHOD" + "     " + "TIME (SEC)");
    System.out.println(
    		  "selectionSort     " + (double) selectionSortEstimatedTime/1000000000 + "\n"
    		+ "bubbleSort        " + (double) bubbleSortEstimatedTime/1000000000 + "\n"
    		+ "shortBubble       " + (double) shortBubbleEstimatedTime/1000000000 + "\n"
    		+ "insertionSort     " + (double) insertionSortEstimatedTime/1000000000 + "\n"
    		+ "mergeSort         " + (double) mergeSortEstimatedTime/1000000000 + "\n"
    		+ "quickSort         " + (double) quickSortEstimatedTime/1000000000 + "\n"
    		+ "heapSort          " + (double) heapSortEstimatedTime/1000000000 + "\n");
  }
}
