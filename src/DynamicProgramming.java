// Complexities --> Space vs Time
// technique --> Code Optimisation --> Reducing running time
// 1. Memoization (storing intermediate results)
//      Pre --> recursive code to problem
import java.util.Arrays;
public class DynamicProgramming {
    public static long fibRecursive(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return fibRecursive(N - 1) + fibRecursive(N -2);
    }
    public static long fibDP(int N) {
        // step1 | create a memo (storage)
        //      --> 1. type of the solution - Number
        //      --> 2. what data structure to use - Array
        //      --> 3. size of the memo (N=5, 0...4 f(0), f(1), f(2), f(3), f(4) )
        long[] memo = new long[N+1];
        // step2 | initial value of the memo [how would you store that result is not found]
        Arrays.fill(memo, -1);
        // step3 | filling the memo with already known results
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
    public static void main(String[] args) {
        System.out.println( fibDP(100) );                     // 2586269025
        System.out.println( fibRecursive(100) );              // 2586269025
    }
}
