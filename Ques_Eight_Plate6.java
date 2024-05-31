import java.util.Arrays;
import java.util.Scanner;

public class Ques_Eight_Plate6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices for the graphs:");
        int n = scanner.nextInt();

        int[][] graph1 = new int[n][n];
        int[][] graph2 = new int[n][n];

        System.out.println("Enter the adjacency matrix for the first graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the adjacency matrix for the second graph:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The two graphs are isomorphic: " + areIsomorphic(graph1, graph2));
    }

    public static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n = graph1.length;
        if (graph2.length != n) {
            return false;
        }

        boolean[] visited = new boolean[n];
        int[] permutation = new int[n];
        Arrays.fill(permutation, -1);

        return isIsomorphicUtil(graph1, graph2, visited, permutation, 0);
    }

    private static boolean isIsomorphicUtil(int[][] graph1, int[][] graph2, boolean[] visited, int[] permutation, int pos) {
        int n = graph1.length;
        if (pos == n) {
            return checkPermutation(graph1, graph2, permutation);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation[pos] = i;

                if (isIsomorphicUtil(graph1, graph2, visited, permutation, pos + 1)) {
                    return true;
                }

                visited[i] = false;
                permutation[pos] = -1;
            }
        }

        return false;
    }

    private static boolean checkPermutation(int[][] graph1, int[][] graph2, int[] permutation) {
        int n = graph1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph1[i][j] != graph2[permutation[i]][permutation[j]]) {
                    return false;
                }
            }
        }
        return true;
    }
}
