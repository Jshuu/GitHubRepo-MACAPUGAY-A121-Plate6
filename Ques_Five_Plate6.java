import java.util.*;

public class Ques_Five_Plate6 {

    public static boolean isBipartite(int[][] edges, int numVertices) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[numVertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < numVertices; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfsCheck(List<List<Integer>> graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();

        int[][] edges = new int[numEdges][2];
        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < numEdges; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }

        boolean result = isBipartite(edges, numVertices);
        if (result) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }

        scanner.close();
    }
}

