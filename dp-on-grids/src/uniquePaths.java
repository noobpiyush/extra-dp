import java.util.Arrays;

public class uniquePaths {

    public static int numberOfPaths(int m, int n) {
        // Code Here
        int dp[][] = new int[m][n];

        for (int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        return memo(m-1,n-1,dp);
    }

    public static int memo(int m, int n, int dp[][]){

        if (m == 0 && n == 0) return 1;

        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        int up = memo(m-1,n,dp);

        int left = memo(m,n-1,dp);

        return dp[m][n] = up + left;
    }

    public static int Tab(int m, int n){
        int dp[][] = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i<m;i++){
            for (int j =0;j<n;j++){
                if (i == 0 && j == 0) continue;

                int down = i > 0 ? dp[i-1][j] : 0;
                int right = j > 0 ? dp[i][j-1] : 0;

                dp[i][j] = down + right;
            }
        }

        return dp[m-1][n-1];
    }
}
