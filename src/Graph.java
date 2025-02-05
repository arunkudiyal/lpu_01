import java.util.ArrayList;
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
        System.out.println();
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
    public void bfs(int start) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> q = new ArrayList<>();
        q.add(start);
        visited[start] = true;
        int current;
        while(!q.isEmpty()) {
            current = q.remove(0);
            System.out.print(current + " ");
            for(int i=0; i < V; i++) {
                if(graph[current][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
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
        graph.dfs(0);
        graph.bfs(0);
    }
}
