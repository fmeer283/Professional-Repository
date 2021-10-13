package Lab13;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void test() {
		WeightedGraphAJF<String> testWeightedGraph = new WeightedGraphAJF<String>();
		
		System.out.println("Is this graph empty? T/F: " + testWeightedGraph.isEmpty() + "\n");
		System.out.println("Is this graph full? T/F: " + testWeightedGraph.isFull() + "\n");
		
		//addVertices
		testWeightedGraph.addVertex("0");
		testWeightedGraph.addVertex("1");
		testWeightedGraph.addVertex("2");
		testWeightedGraph.addVertex("3");
		testWeightedGraph.addVertex("4");
		testWeightedGraph.addVertex("5");
		testWeightedGraph.addVertex("6");
		testWeightedGraph.addVertex("7");
		
		//addEdges
		testWeightedGraph.addTwoWayEdge("0", "1", 5);
		testWeightedGraph.addTwoWayEdge("1", "2", 5);
		testWeightedGraph.addTwoWayEdge("2", "3", 5);
		testWeightedGraph.addTwoWayEdge("2", "4", 10);
		testWeightedGraph.addTwoWayEdge("3", "5", 5);
		testWeightedGraph.addTwoWayEdge("3", "7", 10);
		testWeightedGraph.addTwoWayEdge("4", "7", 10);
		testWeightedGraph.addTwoWayEdge("5", "6", 5);
		testWeightedGraph.addTwoWayEdge("5", "7", 10);
		
		System.out.println("Does the graph have this vertex? T/F: " 
		+ testWeightedGraph.hasVertex("4"));
		
		testWeightedGraph.clearMarks();
		testWeightedGraph.markVertex("0");
		System.out.println("Is this vertex marked? T/F: " 
		+ testWeightedGraph.isMarked("4"));
		
		System.out.println("The first unmarked vertex in this graph is: " 
		+ testWeightedGraph.getUnmarked());
		
		testWeightedGraph.bFirst("0");
		
		testWeightedGraph.dFirst("0");
		
		testWeightedGraph.prims("0");
		
		testWeightedGraph.dijkstras("0", "7");
	}

}
