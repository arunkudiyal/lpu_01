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
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        
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
