package dijkstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.print("Please enter the file name --> ");
		Scanner sc = new Scanner(System.in);
		String filePath = sc.nextLine();
		System.out.print("Enter the starting vertex --> ");
		int source = sc.nextInt() - 1; // Index in array is decrement by 1 of
										// the vertex number.
		sc.close();

		int[][] graph = Graph(filePath);

		Dijkstra dkst = new Dijkstra(graph, source);
		DijkstraResult result = dkst.execute();

		int[] dist = result.getDist();
		int[] prev = result.getPrev();

		System.out.println("Distance list:");
		System.out.println(" 1 2 3 4 5");
		System.out.println(" ---------");
		for (int i : dist) {
			System.out.print(" " + i);
		}
		System.out.println("\nPrevious node list:");
		System.out.println(" 1 2 3 4 5");
		System.out.println(" ---------");
		for (int j : prev) {
			System.out.print(" " + (j + 1));
		}
	}

	// A assist function that help reading the data from the file.
	private static int[][] Graph(String filePath) {
		// Create an empty "container".
		int[][] Graph = null;
		try {
			File file = new File(filePath);
			BufferedReader bf = new BufferedReader(new FileReader(file));

			// Read the first line, which contains the size of the vertices.
			int size = Integer.valueOf(bf.readLine());

			// Initial the graph matrix.
			Graph = new int[size][size];
			// Read line by line.
			for (int i = 0; i < size; i++) {
				String rowChar = bf.readLine();
				// Split one row by spaces, and convert it to integer.
				String[] rowCharSet = rowChar.trim().split("\\s+");
				for (int j = 0; j < size; j++) {
					Graph[i][j] = Integer.valueOf(rowCharSet[j]);
				}
			}
			bf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (e instanceof FileNotFoundException) {
				System.out.println("\nError path: " + filePath);
			}
		}
		return Graph;
	}

}
