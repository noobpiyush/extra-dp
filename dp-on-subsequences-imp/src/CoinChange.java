public class CoinChange {
    /* Given an integer array coins[ ] representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.
Answers are guaranteed to fit into a 32-bit integer.

Examples:

Input: coins[] = [1, 2, 3], sum = 4
Output: 4
Explanation: Four Possible ways are: [1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3].
Input: coins[] = [2, 5, 3, 6], sum = 10
Output: 5
Explanation: Five Possible ways are: [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5].
Input: coins[] = [5, 10], sum = 3
Output: 0
Explanation: Since all coin denominations are greater than sum, no combination can make the target sum.
Constraints:
1 <= sum <= 1e4
1 <= coins[i] <= 1e4
1 <= coins.size() <= 1e3 */

    public static int count(int coins[], int sum) {
        // code here.
        return 1;
    }

//    gfg working code

    public static int memo(int coins[], int T, int index,int dp[][]){

        if (T == 0) return 1;

        if (index == 0){
            if (T % coins[0] == 0) return 1;
            return 0;
        }
        if (index < 0 || T < 0) return 0;

        if(dp[index][T] != -1) return dp[index][T];

        int notTake = memo(coins,T,index-1,dp);

        int take = 0;

        if (T >= coins[index]){
            take = memo(coins,T - coins[index],index,dp);
        }

        dp[index][T] = take + notTake;

        return dp[index][T];
    }


    public static int Tab(int coins[], int sum){
        int n = coins.length;

        int dp[][] = new int[n][sum+1];

        for (int i = 0;i<n;i++){
            dp[i][0] = 1;
        }

        for (int T = 0;T<= sum;T++){
            if (T % coins[0] == 0){
                dp[0][T] = 1;
            }
            else{
                dp[0][T] = 0;
            }
        }


        for (int i = 1;i< n;i++){
            for (int target = 1;target<=sum;target++){

                int notTake = dp[i-1][target];

                int take = 0;

                if (target >= coins[i]){
                    take = dp[i][target-coins[i]];
                }

                dp[i][target] = take + notTake;
            }
        }

        return dp[n-1][sum];
    }




//    strivers works ofr leetcode
//    public static int Memo(int coins[], int sum, int index, int dp[][]) {
//
//        if (index == 0) {
//            if (sum % coins[0] == 0) return sum / coins[0];
//           return (int) Math.pow(10, 9);
//        }
//
//        if (dp[index][sum] != -1) return dp[index][sum];
//
//        int notTake = 0 + Memo(coins, sum, index - 1, dp);
//
//        int take = 0;
//        if (sum >= coins[index]) {
//            take = 1 + Memo(coins, index, sum - coins[index], dp);
//        }
//
//        return dp[index][sum] = Math.min(take, notTake);
//    }

//    public static int Tab(int coins[], int sum) {
//        int n = coins.length;
//
//        int dp[][] = new int[n][sum + 1];
//
//        for (int target = 0; target <= sum; target++) {
//
//            if (target % coins[0] == 0) {
//                dp[0][target] = target / coins[0];
//            }
//              else
//                dp[0][target] = (int) Math.pow(10, 9);
//        }
//
//        for (int index = 1; index < n; index++) {
//
//            for (int target = 1; target <= sum; target++) {
//                int notTake = 0 + dp[index - 1][target];
//                int take = (int) Math.pow(10, 9);
//                if (target >= coins[index]) {
//                    take = 1 + dp[index][target - coins[index]];
//                }
//
//                dp[index][target] = Math.min(take,notTake);
//            }
//        }
//
//       int ans = dp[n - 1][sum];
//
//        // If it's not possible to achieve the target sum, return -1
//        if (ans >= (int) Math.pow(10, 9))
//            return -1;
//        return ans;
//    }
}
