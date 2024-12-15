import java.util.Arrays;

public class Number_of_paths_in_a_matrix_with_k_coins {

    public static long MOD = 1000000007;

    public long numberOfPath(int n, int k, int [][]arr) {
        // code here
        long dp[][][] = new long[n][n][k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return MemoUtil(k,n-1,n-1,arr,dp);
    }

    public static long MemoUtil(int k, int i, int j,int arr[][], long dp[][][]){

        if(i == 0 && j == 0 )  return k == arr[0][0] ? 1 : 0L;

        if (i < 0 || j < 0 || k < 0) return 0;

        if (dp[i][j][k] != -1) return dp[i][j][k];

        long left = i > 0 && k > 0 ? MemoUtil(k - arr[i][j], i -1, j, arr,dp) %MOD : 0L;

        long right = j > 0 && k > 0 ? MemoUtil(k- arr[i][j], i, j-1, arr, dp) % MOD : 0L;

        return dp[i][j][k] =  (left + right) %MOD;

    }

//    public static long Tab(int n, int k, int arr[][]){
//
//        long dp[][][] = new long[n][n][k+1];
//
//        dp[0][0][k] = 1;
//
//        for (int i =0;i<n;i++){
//            for(int j =0;j <n;j++){
//
//                for (int l  =0;l<=k;l++){
//                    if (i ==0 && j ==0 ) continue;
//
//                    long left = i > 0 ?
//                }
//            }
//        }
//
//    }


}
