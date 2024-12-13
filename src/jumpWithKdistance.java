import java.lang.reflect.Array;
import java.util.Arrays;

public class jumpWithKdistance {

    public static int minimizeCostMemo(int k, int arr[]) {
        // code here
        int n = arr.length;
        int dp [] = new int[n];
        Arrays.fill(dp,-1);

        return minimizeCostMemoUtil(arr,dp,n-1,k);
    }
    public static int minimizeCostTabulation(int k, int arr[]) {
        // code here
        int n = arr.length;
        int dp [] = new int[n];

        dp[0] = 0;

        for (int i = 1;i<n;i++){

            int minDistance = Integer.MAX_VALUE;

            for (int j = 1;j<=k;j++){
               if (i - j  >= 0){
                   int jumps = dp[i - j] + Math.abs(arr[i - j] - arr[i]);
                   minDistance = Math.min(minDistance,jumps);
               }
            }

            dp[i] = minDistance;
        }

        return dp[n-1];
    }

    public static int minimizeCostMemoUtil(int arr[], int dp[] ,int index, int k) {
        // code here

        if (index == 0) return 0;

        if (dp[index] != -1){
            return dp[index];
        }

        int minDistance = Integer.MAX_VALUE;

        for (int i = 1;i <= k;i++){
           if (index  - i >= 0){
               int jumps = minimizeCostMemoUtil(arr, dp,index - i,k)
                       + Math.abs(arr[index] -  arr[index - i]);
               minDistance = Math.min(minDistance,jumps);
           }
        }

        return dp[index] = minDistance;
    }

}
