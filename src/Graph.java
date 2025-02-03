import java.util.Arrays;
import java.util.Scanner;
public class Graph {
    int V;
    int[][] graph;
    Graph(int V) {
        this.V = V;
        this.graph = new int[V][V];
    }
    public void dfs(int start) {
        boolean[] visited = new boolean[V];
        // Arrays.fill(visited, false);
        dfsUtil(start, visited);
    }
    public void dfsUtil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for(int i=0; i < V; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = 6;
        Graph graph = new Graph(V);
        graph.graph = new int[][] {
                {0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0}
        };
        graph.dfs(1);
    }
}
