import java.util.Arrays;

public class ncr {
//   ncr = n-1c r-1 + n-1cr

    public static int nCrMemoUtil(int n, int r, int dp[][]) {
        // code here

        if (r > n) return 0;

        if (r == 0 || r == n) return 1;

        if (dp[n][r] != -1){
            return dp[n][r];
        }

        return dp[n][r] = nCrMemoUtil(n-1,r-1, dp) + nCrMemoUtil(n-1,r,  dp);

    }

    public int nCrMemo(int n, int r) {
        // code here
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        int dp[][] = new int[n+1][r+1];

        for (int i = 0; i <= n; i++ ){
            for (int j = 0;j<=r;j++){
                dp[i][j] = -1;
            }
        }

        return nCrMemoUtil(n,r,dp);

    }
    public static int nCrTab(int n, int r) {
        // code here
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        int dp[][] = new int[n+1][r+1];



        for (int i = 0; i <= n; i++ ){
            dp[i][0] = 1;

            if(i <= r) dp[i][i] = 1;
        }

        for (int i =1;i<=n;i++){
            for (int j = 1;j<=Math.min(i,r);j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        return dp[n][r];

    }


    public static void main(String[] args) {
        int n = 30;
        int r = 7;

        System.out.println(nCrTab(n,r));
    }



}
