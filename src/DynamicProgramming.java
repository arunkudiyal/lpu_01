// Complexities --> Space vs Time
// technique --> Code Optimisation --> Reducing running time
// 1. Memoization (storing intermediate results)
//      Pre --> recursive code to problem
import java.util.ArrayList;
import java.util.Arrays;
public class DynamicProgramming {
    public static long fibRecursive(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return fibRecursive(N - 1) + fibRecursive(N -2);
    }
    public static int gridTravellerRecursive(int N, int M) {
        if(N == 0 || M == 0) return 0;
        if(N == 1 && M == 1) return 1;
        return gridTravellerRecursive(N, M-1) +
                gridTravellerRecursive(N-1, M);
    }
    public static long fibDP(int N) {
        // step1 | create a memo (storage)
        //      --> 1. type of the solution - Number
        //      --> 2. what data structure to use - Array
        //      --> 3. size of the memo (N=5, 0...4 f(0), f(1), f(2), f(3), f(4) )
        //      --> 4. initial value of the memo [how would you store that result is not found]
        long[] memo = new long[N+1];
        Arrays.fill(memo, -1);
        // step2 | filling the memo with already known results
        memo[0] = 0;
        memo[1] = 1;
        // step4 | call a utility function & pass all the parameters along with the memo
        return fibDPUtil(N, memo);
    }
    public static long fibDPUtil(int N, long[] memo) {
        // step5 | check if the answer already exists in the memo,
        // if yes, return the answer directly without calculation
        if(memo[N] != -1) return memo[N];
        // step6 | specify base cases & return answers from the memo
        if(N == 0) return memo[0];
        if(N == 1) return memo[1];
        // step 7 | if the answers is not calculated, then calculate, store & return it.
        memo[N] = fibDPUtil(N-1, memo) + fibDPUtil(N-2, memo);
        return memo[N];
    }
    public long fibTabular(int N) {
        long[] dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i <= N; i++) dp[i] = dp[i-1] + dp[i-2];
        return dp[N];
    }
    public static int gridTravellerTabular(int N, int M) {
        int[][] dp = new int[N+1][M+1];
        for(int i=0 ; i <= M; i++) dp[0][i] = 0;
        for(int i=0 ; i <= N; i++) dp[i][0] = 0;
        dp[1][1] = 1;
        for(int i=0 ; i <= M; i++) dp[1][i] = 1;
        for(int i=0 ; i <= N; i++) dp[i][1] = 1;
        for(int i = 2; i <= N; i++) {
            for(int j = 2; j <= M; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[N][M];
    }
    public static void main(String[] args) {
        System.out.println( fibDP(100) );                           // 2586269025
        // System.out.println( fibRecursive(100) );                    // 2586269025
        System.out.println( gridTravellerTabular(25, 25) );         // 3
    }
}
