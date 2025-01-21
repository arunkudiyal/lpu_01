import java.util.Scanner;
public class Recursion {
    public int fib(int term) {
        if(term == 0) return 0;
        if(term == 1) return 1;
        return fib(term - 1) + fib(term -2);
    }
    public static int gridTraveller(int N, int M) {
        if(N == 0 || M == 0) return 0;
        if(N == 1 && M == 1) return 1;
        return gridTraveller(N, M-1) + gridTraveller(N-1, M);
    }
    public static int placeTile(int N, int M) {
        if(M == N) return 2;
        if(N < M) return 1;
        return placeTile(N-1, M) + placeTile(N-M, M);
    }
    public static int knapsack01(int N, int[] values, int[] weights, int W) {
        if(N == 0 || W == 0) return 0;
        if(weights[N-1] > W) knapsack01(N-1, weights, values, W);
        return Math.max(values[N-1] + knapsack01(N-1, values, weights, W-weights[N-1]),
                knapsack01(N-1, values, weights, W));
    }
    public static boolean coinChange(int[] coins, int amount) {
        if(amount == 0) return true;
        if(amount < 0) return false;
        for(int i=0; i < coins.length; i++) {
            int remainingAmount = amount - coins[i];
            return coinChange(coins, remainingAmount);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* int term = sc.nextInt();
        System.out.println( fib(term) ); */

        /* System.out.println( gridTraveller(2, 3) );          // 3
        System.out.println( gridTraveller(3, 3) );          // 6 */

        /* int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0; i < n; i++) coins[i] = sc.nextInt();
        int amount = sc.nextInt();
        System.out.println( coinChange(coins, amount) ); */

        /* int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.println( placeTile(N, M) ); */

        Recursion recursion = new Recursion();
        recursion.fib(5);

        int N = sc.nextInt();
        int[] values = new int[N];
        for(int i=0; i < N; i++) values[i] = sc.nextInt();
        int[] weights = new int[N];
        for(int i=0; i < N; i++) weights[i] = sc.nextInt();
        int W = sc.nextInt();
        System.out.println( knapsack01(N, values, weights, W) );
    }
}
