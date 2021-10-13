package Lab13;

import Dale_Imports.LinkedStack;
import Dale_Imports.LinkedUnbndQueue;
import Dale_Imports.ListInterface;
import Dale_Imports.RefUnsortedList;
import Dale_Imports.UnboundedQueueInterface;
import Dale_Imports.UnboundedStackInterface;

//AJF: added my own Prim's alg, Dijkstra's alg, and
//     breadth-first and depth-first spanning tree algs
// requires change to WeightedGraph class: most data fields 
// and one method changed from private to protected


public class WeightedGraphAJF<T> extends WeightedGraph<T> {
	public void dijkstras(T origin, T terminus) {
		System.out.println("Dijkstras on " + origin + " to " + terminus);
		
		int[] distance = new int[maxVertices]; 
		// keeps shortest known distance from origin
		// to that vertex
		
		T[] lastVertex = (T[]) new Object[maxVertices]; 
		//where shortest path comes from
		
		
		//initialize distance values (origin to 0, others to infty)
		int index =0;
		while (index < numVertices) {
			if(vertices[index].equals(origin)) {
				distance[index] = 0;
				lastVertex[index] = origin;
			}
			else
				distance[index] = -1; // -1 means infinity here
			index++;
		}
		
		//initialize marks (all unmarked).  Marked = solved
		clearMarks();	
		
		System.out.println("Last Vertex   Destination   Distance"); 
		System.out.println("------------------------------------");
		while(!isMarked(terminus)) {
			//solve a node: the unsolved node w/ smallest distance value
			index = 0;
			int smallestIndex = -1;
			int smallestDistance = -1;
			// It would be better to make a priQueue of T (prioritized by distance)
			while (index < numVertices) {
				if((!marks[index]) && (distance[index] >= 0)) {
					if((smallestDistance == -1) || (distance[index]< smallestDistance)){
						smallestDistance = distance[index];
						smallestIndex = index;
					}
				}
				index++;
			}
			marks[smallestIndex] = true;// marks it as solved
			// print out solved node
			System.out.println("     " + lastVertex[smallestIndex] + "             " + 
			    vertices[smallestIndex] + "            " + smallestDistance);
			
			//update nodes adjacent to just-solved node
			UnboundedQueueInterface<T> adjNodes = this.getToVertices(vertices[smallestIndex]);
			while(!adjNodes.isEmpty()) {
				T adjacentNode = adjNodes.dequeue();
				int adjIndex = this.indexIs(adjacentNode);
				int newDistance = distance[smallestIndex] + edges[smallestIndex][adjIndex];
				if( (distance[adjIndex] == -1) || (distance[adjIndex] > newDistance )) {
						distance[adjIndex] = newDistance;
						lastVertex[adjIndex] = vertices[smallestIndex];
				}
			}
		}	
		// now terminus is solved
		
	}

	public int prims(T startVertex) {
		ListInterface<T> tree = new RefUnsortedList<T>();
		T inTreeVertex;
		UnboundedQueueInterface<T> possibleConnections;
		T otherVertex;
		T smallestToVertex = null;
		T smallestFromVertex = null;
		int smallestWeight=0;
		int totalTreeWeight = 0;
		
		System.out.println("\nPrims Algorithm:\n From To Weight");
		
		this.clearMarks(); // marks indicate if vertex is in tree or not
		tree.add(startVertex);
		this.markVertex(startVertex);
		while(this.getUnmarked() != null) {
			// find the best edge to add
			// edge must have one end in tree, other end out of tree
			tree.reset();
			boolean first = true; // is it first qualifying edge
			for(int i=0; i<tree.size(); i++){
				// look at each node in tree
				inTreeVertex = tree.getNext();
				// find all that node's possible connections
				possibleConnections = this.getToVertices(inTreeVertex);
				while(!possibleConnections.isEmpty()) {
					otherVertex = possibleConnections.dequeue();
					if(!this.isMarked(otherVertex)) {
						// (inTreeVertex, otherVertex) qualifies!
						int weight = this.weightIs(inTreeVertex, otherVertex);
						if(first || (weight < smallestWeight)) {
							first = false;
							smallestWeight = weight;
							smallestToVertex = otherVertex;
							smallestFromVertex = inTreeVertex;
						}
					}
				}
			}
			// found best edge to add
			tree.add(smallestToVertex);
			totalTreeWeight += smallestWeight;
			this.markVertex(smallestToVertex);
			System.out.println("   " + smallestFromVertex + "   " 
			+ smallestToVertex + "   "	+ smallestWeight);
		}
		System.out.println("\n Total Weight: " + totalTreeWeight);
		return totalTreeWeight;
	}
	
	public void dFirst(T startVertex){
		//Prints the depth-first spanning tree starting at startVertex
		System.out.println("\n Depth-first starting at " + startVertex);

		UnboundedStackInterface<T> stack = new LinkedStack<T>();
		UnboundedQueueInterface<T> vertexQueue = new LinkedUnbndQueue<T>();
	
		T vertex;
		T item;
	
		this.clearMarks();
		stack.push(startVertex);
		do{
			vertex = stack.top();
			if (!this.isMarked(vertex))
				this.markVertex(vertex);
			vertexQueue = this.getToVertices(vertex);
			// Note: vertexQueue is NOT necessarily in 
			// alphabetical order, which makes it not always
			// the depth-first algorithm taught in M209
			boolean foundUnmarked = false;
			if(vertexQueue.isEmpty())
				stack.pop();
			while (!vertexQueue.isEmpty() && !foundUnmarked){
				item = vertexQueue.dequeue();
				if (!this.isMarked(item)) {
					foundUnmarked = true;
					System.out.println("edge:  " + vertex + "  " + item);
					stack.push(item);
				}
				else if(vertexQueue.isEmpty())// all adjacent are marked
						stack.pop();
			}
		} while (!stack.isEmpty());
	
	}

	public void bFirst(T startVertex){
	//Prints the breadth-first spanning tree starting at startVertex
		System.out.println("\n Breadth-first starting at " + startVertex);
		
		UnboundedQueueInterface<T> mainQueue = new LinkedUnbndQueue<T>();
		UnboundedQueueInterface<T> vertexQueue = new LinkedUnbndQueue<T>();
		
		T vertex;
		T item;
		
		this.clearMarks();
		mainQueue.enqueue(startVertex);
		this.markVertex(startVertex);
		do{
			vertex = mainQueue.dequeue();
			vertexQueue = this.getToVertices(vertex);
			// Note: vertexQueue is NOT necessarily in 
			// alphabetical order, which makes it not always
			// the breadth-first algorithm taught in M209
			while (!vertexQueue.isEmpty()){
				item = vertexQueue.dequeue();
				if (!this.isMarked(item)) {
					System.out.println("edge:  " + vertex + "  " + item);
					mainQueue.enqueue(item);
					this.markVertex(item);
				}
			}
		} while (!mainQueue.isEmpty());
		
	}

	public void addTwoWayEdge(T oneNode, T otherNode, int weight) {
		// utility method, adds two opposing one-way edges when
		// user wants a two-way edge with
		addEdge(oneNode, otherNode, weight);
		addEdge(otherNode, oneNode, weight);
	}


}
