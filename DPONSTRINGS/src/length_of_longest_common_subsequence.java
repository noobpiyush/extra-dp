import java.util.Arrays;

public class length_of_longest_common_subsequence {

    static int getLCSLength(String s1, String s2) {
        // your code here
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for (int rows[]:dp){
            Arrays.fill(rows,-1);
        }

        System.out.println(Memo(s1,s2,n,m,dp));

        return Tab(s1,s2);
    }

    public static int Memo(String s1, String s2, int i, int j,int dp[][]){
        if (i ==0 || j == 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        //match case
        if (s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = 1 + Memo(s1,s2,i-1,j-1,dp);
        }
        //non match case
        return dp[i][j] = Math.max(Memo(s1,s2,i-1,j,dp), Memo(s1,s2,i,j-1,dp));
    }

    public static int Tab(String s1, String s2){
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

        return dp[n][m];
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";

        System.out.println(getLCSLength(text1,text2));
    }
}
