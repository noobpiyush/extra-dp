/* Given two strings, txt and pat, find the count of distinct occurrences of pat as a subsequence in txt.

Note: It is guaranteed that the output will fit within 31 bits.

Examples:

Input: txt = "banana" , pat = "ban"
Output: 3
Explanation: There are 3 sub-sequences:[ban], [ba n], [b an].
Input: txt = "geeksforgeeks" , pat = "ge"
Output: 6
Explanation: There are 6 sub-sequences:[ge], [ge], [g e], [g e] [g e] and [g e].
Input: txt = "aabbcc" , pat = "abc"
Output: 8
Explanation: There are 8 distinct subsequences: [a b c], [a b c], [a b c], [a b c], [a b c], [a b c], [a b c], [a b c].
Constraints:
1 ≤ txt.length(), pat.length() ≤ 103
Both txt and pat contain only lowercase alphabets. */

public class DistinctSubsequences {

    public int subsequenceCount(String txt, String pat) {
        // code here
        return 1;
    }

    public static int Memo(String s1, String s2, int i, int j, int dp[][]){

        //base case 1 based indexing
        //first string exhausted 2nd string is still left
        if (i == 0) return 0;

        //2nd string exhausted
        if (j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        //match case

        if (s1.charAt(i-1) == s2.charAt(j-1)){
            //2 choices consider or not consider

            return dp[i][j] = Memo(s1,s2,i-1,j-1,dp) + Memo(s1,s2,i-1,j,dp);
        }

        return dp[i][j] = Memo(s1,s2,i-1,j,dp);
    }

    public static int Tab(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        
        int dp[][] = new int[n+1][m+1];

        for (int i = 0;i<=n;i++){
            dp[i][0] = 1;
        }

        for (int i =1;i<=n;i++){
            for (int j =1;j<=m;j++){

                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    //2 choices consider or not consider

                     dp[i][j] = dp[i-1][j-1] +  dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][m];
    }

}
