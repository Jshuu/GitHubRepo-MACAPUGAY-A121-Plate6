import java.util.*;

public class Ques_Six_Plate6 {

    private int[][] adjacencyMatrix;
    private int numVertices;

    public Ques_Six_Plate6(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] += 1; // For multiple edges
        adjacencyMatrix[destination][source] += 1; // If undirected
    }

    public void display() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        Ques_Six_Plate6 graph = new Ques_Six_Plate6(numVertices);
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();
        System.out.println("Enter the edges (vertex pairs):");
        for (int i = 0; i < numEdges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
        graph.display();
    }
}