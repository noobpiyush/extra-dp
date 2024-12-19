import java.util.Arrays;

public class DecodeWays {

    public static int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);

        return memo(s,0,n,dp);
    }

    public static int memo(String s, int index, int n, int dp[]){

       if (index >= n){
           return 1;
       }

       if (dp[index] != -1) return dp[index];

       int ways = 0;

        // Single-digit decoding: check if current digit is not '0'.
       if (s.charAt(index) != '0'){
           ways =  memo(s,index+1,n,dp);
       }

       //double-digit decoding  check if next two digits are valid.

        if ((index + 1 < n) && ((s.charAt(index) == '1' &&
                s.charAt(index + 1) <= '9') ||
                (s.charAt(index) == '2' &&
                        s.charAt(index + 1) <= '6'))) {

            ways += memo(s, index + 2,n, dp);
        }

        return dp[index] = ways;

    }

    public static int Tab(String s){
        int n = s.length();

        int dp[] = new int[n+1];

        dp[n] = 1;

        for (int i = n-1;i>=0;i--){
            int ways = 0;
            if (s.charAt(i) != '0'){
                ways =  dp[i+1];
            }
            if ((i + 1 < n) && ((s.charAt(i) == '1' &&
                    s.charAt(i + 1) <= '9') ||
                    (s.charAt(i) == '2' &&
                            s.charAt(i + 1) <= '6'))) {

                ways += dp[i+2];
            }
            dp[i] = ways;
        }


        return dp[0];
    }

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
        System.out.println(Tab(s));
    }
}
