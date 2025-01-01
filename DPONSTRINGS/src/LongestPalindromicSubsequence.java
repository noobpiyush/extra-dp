public class LongestPalindromicSubsequence {

    /* Given a string s, find the longest palindromic subsequence's length in s.
    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
    Example 1:
    Input: s = "bbbab"
    Output: 4
    Explanation: One possible longest palindromic subsequence is "bbbb".
    Example 2:
I   input: s = "cbbd"
    Output: 2
    Explanation: One possible longest palindromic subsequence is "bb". */

    public int longestPalinSubseq(String s) {
        // code here

        String reversed = new StringBuilder(s).reverse().toString();

        int n = reversed.length();

        int dp[][] = new int[n+1][n+1];

        for (int i = 1;i<=n;i++){
            for(int j = 1;j<=n;j++){

                if (s.charAt(i-1) == reversed.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }


}
