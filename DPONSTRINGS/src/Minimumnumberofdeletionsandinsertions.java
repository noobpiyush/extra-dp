public class Minimumnumberofdeletionsandinsertions {

//    Given two strings s1 and s2. The task is to remove or insert the minimum number of characters from/in s1 to transform it into s2. It could be possible that the same character needs to be removed from one point of s1 and inserted into another point.
//    Examples :
//    Input: s1 = "heap", s2 = "pea"
//    Output: 3
//    Explanation: 'p' and 'h' deleted from heap. Then, 'p' is inserted at the beginning.
//            Input : s1 = "geeksforgeeks", s2 = "geeks"
//    Output: 8
//    Explanation: 8 deletions, i.e. remove all characters of the string "forgeeks".
//    Constraints:
//            1 ≤ s1.size(), s2.size() ≤ 1000
//    All the characters are lowercase English alphabets.

    public int minOperations(String s1, String s2) {
        // Your code goes here
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

        int lcs = dp[n][m];

        return (n - lcs) + (m - lcs);
    }

}
