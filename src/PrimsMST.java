import java.util.Arrays;
public class PrimsMST {
    int V;
    int[][] graph;
    PrimsMST(int V) {
        this.V = V;
        this.graph = new int[V][V];
    }
    public void prims(int start) {
        boolean[] visited = new boolean[V];
        int[] cost = new int[V];
        int[] parent = new int[V];
        parent[start] = -1;
        // Arrays.fill(cost, Integer.MAX_VALUE);
        for(int i=0; i < V; i++) cost[i] = Integer.MAX_VALUE;
        cost[start] = 0;
        for(int i=0; i < V-1; i++) {
            int u = minVertex(cost, visited);               // u --> Source
            visited[u] = true;
            for(int v=0; v < V; v++) {                      // v --> Destination
                if(graph[u][v] > 0 && !visited[v]
                        && cost[v] >= graph[u][v]) {
                    cost[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }
        // printing cost[]
        int totalMinCost = 0;
        System.out.println("S_to_D\tCost");
        for(int i=0; i < V; i++) {
            totalMinCost += cost[i];
            System.out.println(parent[i] + " - " + i + "\t" +cost[i] + " ");
        }
        System.out.println();
        System.out.println(totalMinCost);                       // 37
    }
    public int minVertex(int[] cost, boolean[] visited) {
        int minVertex = -1; int minCost = Integer.MAX_VALUE;
        for(int i=0; i < V; i++) {
            if(cost[i] < minCost && !visited[i]) {
                minCost = cost[i];
                minVertex = i;
            }
        }
        return minVertex;
    }
    public static void main(String[] args) {
        PrimsMST mst = new PrimsMST(9);
        mst.graph = new int[][] {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        mst.prims(0);
    }
}
