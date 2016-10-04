package dijkstra;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Core implementation of the Dijkstra algorithm.
 * 
 * @author Tian
 *
 */
public class Dijkstra {

	// Initial arguments
	private int[][] graph;
	private int source;
	private int size;

	// A constructor that passes the inputs into the arguments.
	public Dijkstra(int[][] graph, int source) {
		this.graph = graph;
		this.source = source;
		this.size = graph.length;
	}

	// Execute the function of the algorithm.
	public DijkstraResult execute() {

		HashSet<Integer> Q = new HashSet<Integer>(); // Stores the unvisited
														// nodes.

		int[] dist = new int[size]; // Distance from source to each node
		int[] prev = new int[size]; // Previous node of each node (path record)

		// Initialization.
		for (int i = 0; i < size; i++) {
			dist[i] = Integer.MAX_VALUE; // Unknown distance.
			prev[i] = -1; // Unknown previous node.
			Q.add(i); // All nodes are not visited yet.
		}

		dist[source] = 0; // Initial distance from source to source, which is 0.

		while (!Q.isEmpty()) {
			int u = minDistIndex(Q, dist); // Choose the nearest node.
			Q.remove(u);

			for (int v : neighbor(u)) {
				if (Q.contains(v)) { // If v is not visited
					int alt = dist[u] + graph[u][v];
					if (alt < dist[v]) {
						dist[v] = alt; // a shorter path found.
						prev[v] = u;
					}
				}
			}
		}

		DijkstraResult result = new DijkstraResult(dist, prev);
		return result;
	}

	// "Find the shortest distance node from set" subroutine
	private int minDistIndex(HashSet<Integer> Q, int dist[]) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i : Q) {
			if (dist[i] < min) {
				min = dist[i];
				index = i;
			}
		}
		return index;
	}

	// A subroutine that finds the indexes of neighbor nodes.
	private ArrayList<Integer> neighbor(int u) {
		ArrayList<Integer> ngbor = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			if (graph[u][i] != 0) {
				ngbor.add(i);
			}
		}
		return ngbor;
	}
}
