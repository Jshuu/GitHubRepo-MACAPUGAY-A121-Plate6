import java.util.*;

public class Ques_Seven_Plate6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();
        
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();
        
        int[][] incidenceMatrix = new int[numVertices][numEdges];
        Map<String, Integer> edgeMap = new HashMap<>();
        int edgeIndex = 0;
        
        System.out.println("Enter the edges in the format 'u v' and the number of times the edge appears:");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int count = scanner.nextInt();
            
            String edgeKey = u < v ? u + "-" + v : v + "-" + u;
            if (!edgeMap.containsKey(edgeKey)) {
                edgeMap.put(edgeKey, edgeIndex++);
            }
            
            int index = edgeMap.get(edgeKey);
            incidenceMatrix[u][index] += count;
            incidenceMatrix[v][index] += count;
        }
        
        scanner.close();
        
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < edgeIndex; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
