import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ques_Two_Plate6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();

        // Get the adjacency matrix
        int[][] adjacencyMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Create a map to count the edges
        Map<String, Integer> edgeCount = new HashMap<>();

        // Process the adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMatrix[i][j] > 0) {
                    String edge = i < j ? i + "-" + j : j + "-" + i;
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + adjacencyMatrix[i][j]);
                }
            }
        }

        // Print the edges and their counts
        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
