public class Paths_to_reach_origin {

    static final int MOD = 1000000007;

    public static int waysMemo(int n, int m)
    {
        // complete the function

        int dp[][] = new int[n+1][m+1];

        return memoUtil(n,m,0,0,dp);

    }

    public static int memoUtil(int n, int m,int i, int j, int dp[][]){

        if(i == n && j == m){
            return 1;
        }

        if (i > n || j > m) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        int down = memoUtil(n,m,i+1,j,dp) % MOD;

        int right = memoUtil(n,m,i,j+1,dp) %MOD;

        return dp[i][j] = (right + down)%MOD;
    }

    public static int waysTab(int n,int m){

        int dp[][] = new int[n+1][m+1];

        dp[0][0] = 1;

        for (int i =0;i<=n;i++){
            for (int j = 0;j<=m;j++){
                if (i ==0 && j == 0) continue;

                int left = i - 1 >= 0 ? dp[i-1][j] % MOD: 0;

                int right = j -1 >= 0 ? dp[i][j-1] % MOD: 0;

                dp[i][j] = (left + right) % MOD;
            }
        }

        return dp[n][m];
    }



    public static void main(String[] args) {
        int x = 35, y = 31;
        System.out.println(waysMemo(x,y));
        System.out.println("tab soln down");
        System.out.println("");
        System.out.println(waysTab(x,y));
    }
}
