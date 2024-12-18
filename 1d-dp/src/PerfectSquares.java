public class PerfectSquares {

    public static int numSquares(int n) {
        int dp[] = new int[n+1];

        for (int i  =0;i<=n;i++){
            dp[i] = -1;
        }

        return memo(n,dp);
    }

    public static int memo(int n, int dp[]){
        if(n==0) return  0;

        if (dp[n] != -1) return dp[n];

        int minCnt = Integer.MAX_VALUE;

        for (int i =1;i*i<=n;i++){
            int sq = i * i;
            int cnt = 1 + memo(n - sq ,dp);
            minCnt = Math.min(minCnt,cnt);
        }

        return dp[n] = minCnt;
    }

    public static int Tab(int n){
        int dp[] = new int[n+1];

        dp[0] = 0;
        for(int i = 1;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i  = 1;i<=n;i++){
            for (int j = 1;j*j<=i;j++){
                int sq = j * j;
                dp[i] = Math.min(dp[i], 1  + dp[i-sq]);
            }
        }

        return dp[n];
    }

    public static int spaceOpt(int n){
        int prev = 0;
        int cur = 0;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j*j<=i;j++){
                int sq = i * i;
                cur = Math.min(cur,1 + i - prev);
                prev = cur;
            }
        }

        return prev;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(56));
    }
}
