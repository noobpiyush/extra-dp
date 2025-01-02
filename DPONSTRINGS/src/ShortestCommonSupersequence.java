public class ShortestCommonSupersequence {

    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=m;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int i = n, j = m;
        int ans = 0;
        while (i > 0 && j > 0){
            if (s1.charAt(i-1) == s2.charAt(j-1)){
                ans  += 1;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                ans +=1;
                i--;
            }
            else{
                ans +=1;
                j--;
            }
        }

        while(i > 0){
            ans +=1;
            i--;
        }

        while (j > 0){
            ans += 1;
            j--;
        }

        return ans;
    }
}
