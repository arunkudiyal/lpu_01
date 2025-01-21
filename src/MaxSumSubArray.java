import java.util.Scanner;
public class MaxSumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int sum; int currentSum = 0;
        for(int i=0; i < k; i++) currentSum += arr[i];
        sum = currentSum;
        for(int j=k; j < n; j++) {
            currentSum = (currentSum - arr[j-k]) + arr[j];
            sum = Math.max(sum, currentSum);
        }
        System.out.println(sum);
    }
}
