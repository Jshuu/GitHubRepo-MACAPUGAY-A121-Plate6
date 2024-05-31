import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ques_Four_Plate6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of edges
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        // Initialize a map to store the degree of each vertex
        Map<Integer, Integer> vertexDegreeMap = new HashMap<>();

        System.out.println("Enter the pairs of vertices (one pair per line):");

        // Read each edge
        for (int i = 0; i < numEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();

            // Increase the degree of vertex1
            vertexDegreeMap.put(vertex1, vertexDegreeMap.getOrDefault(vertex1, 0) + 1);
            // Increase the degree of vertex2
            vertexDegreeMap.put(vertex2, vertexDegreeMap.getOrDefault(vertex2, 0) + 1);
        }

        scanner.close();

        // Print the degree of each vertex
        System.out.println("Degree of each vertex:");
        for (Map.Entry<Integer, Integer> entry : vertexDegreeMap.entrySet()) {
            System.out.println("Vertex " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

