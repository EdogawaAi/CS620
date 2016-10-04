package dijkstra;

/**
 * A data structure for storing the Dijkstra algorithm's result, which contains
 * two int[] arrays.
 * 
 * @author Tian
 *
 */
public class DijkstraResult {

	private int[] dist;
	private int[] prev;

	public DijkstraResult(int[] dist, int[] prev) {
		this.dist = dist;
		this.prev = prev;
	}

	public int[] getDist() {
		return dist;
	}

	public int[] getPrev() {
		return prev;
	}
}
