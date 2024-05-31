import java.util.*;

class Ques_Three_Plate6 {
    private final int V;
    private final LinkedList<Integer>[] adj;
    private final boolean isDirected;

    Ques_Three_Plate6(int V, boolean isDirected) {
        this.V = V;
        this.isDirected = isDirected;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        if (!isDirected) {
            adj[w].add(v); // If the graph is undirected, add the edge in both directions
        }
    }

    // Cycle detection for undirected graph
    private boolean isCyclicUtilUndirected(int v, boolean[] visited, int parent) {
        visited[v] = true;

        for (Integer i : adj[v]) {
            if (!visited[i]) {
                if (isCyclicUtilUndirected(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    // Cycle detection for directed graph
    private boolean isCyclicUtilDirected(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        recStack[v] = true;

        for (Integer i : adj[v]) {
            if (isCyclicUtilDirected(i, visited, recStack)) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[V];

        if (isDirected) {
            boolean[] recStack = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (isCyclicUtilDirected(i, visited, recStack)) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    if (isCyclicUtilUndirected(i, visited, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.print("Is the graph directed (true/false)? ");
        boolean isDirected = scanner.nextBoolean();

        Ques_Three_Plate6 graph = new Ques_Three_Plate6(vertices, isDirected);

        System.out.println("Enter the edges (format: <from> <to>): ");
        for (int i = 0; i < edges; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.addEdge(from, to);
        }

        if (graph.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }

        scanner.close();
    }
}