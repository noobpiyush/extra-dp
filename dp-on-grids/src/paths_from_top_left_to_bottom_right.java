import javax.print.DocFlavor;

public class paths_from_top_left_to_bottom_right {

    static long MOD = 1_000_000_007;

    public static long numberOfPathsMemo(int m, int n) {
        // code here

       long dp[][] = new long[m+1][n+1];

       for (int i =0;i<=m;i++){
           for (int j = 0;j<=n;j++){
               dp[i][j] = -1;
           }
       }

       return memoUtil(m,n,m-1,n-1,dp);

   }

   public static long memoUtil(int n,int m, int i, int j, long dp[][]){
       // base cases

       if (i == 0 && j == 0){
           return 1;
       }

       if (i < 0 || j < 0 ) return 0;

       if (dp[i][j] != -1) return dp[i][j];

       long up = i > 0 ? memoUtil(n,m,i-1,j,dp)% MOD : 0L;

       long  left = j > 0 ? memoUtil(n,m,i,j-1,dp)% MOD : 0L;

       return dp[i][j] = (up + left) % MOD;

   }

   public  static long numberOfPathsTab(int m, int n){

       long dp[][] = new long[m+1][n+1];
       dp[0][0] = 1; // There's only one way to start at the origin

       // Fill the table row by row
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (i == 0 && j == 0) {
                   continue; // Skip the origin
               }

               // Get paths from above (up) and left
               long up = (i > 0) ? dp[i-1][j] : 0;
               long left = (j > 0) ? dp[i][j-1] : 0;

               // Current cell value is the sum of up and left
               dp[i][j] = (up + left) % MOD;
           }
       }

       // Result is in the bottom-right corner
       return dp[m-1][n-1];
   }


}
