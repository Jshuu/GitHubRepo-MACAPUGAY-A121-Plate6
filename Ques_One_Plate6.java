import java.util.*;

public class Ques_One_Plate6 {

    private static class Graph {
        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new LinkedList<>());
            }
        }

        public void addEdge(int v, int w) {
            adj.get(v).add(w);
            adj.get(w).add(v);
        }

        private void Search(int v, boolean[] visited) {
            visited[v] = true;
            for (int n : adj.get(v)) {
                if (!visited[n]) {
                    Search(n, visited);
                }
            }
        }

        public boolean isConnected() {
            boolean[] visited = new boolean[V];
            Search(0, visited);

            for (boolean visitStatus : visited) {
                if (!visitStatus) {
                    return false;
                }
            }
            return true;
        }

        public int countConnectedComponents() {
            boolean[] visited = new boolean[V];
            int count = 0;
            for (int v = 0; v < V; ++v) {
                if (!visited[v]) {
                    Search(v, visited);
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int V = scanner.nextInt();
        System.out.println("Enter number of edges:");
        int E = scanner.nextInt();

        Graph graph = new Graph(V);

        System.out.println("Enter edges (vertex pairs):");
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            graph.addEdge(v, w);
        }

        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            int connectedComponents = graph.countConnectedComponents();
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + connectedComponents);
        }

        scanner.close();
    }
}
