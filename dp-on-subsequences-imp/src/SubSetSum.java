//Given an array of positive integers, arr[] and a value, target, determine if there is a subset of the given set with sum equal to given target.
//
//Examples:
//
//Input: arr[] = [3, 34, 4, 12, 5, 2], target = 9
//Output: true
//Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
//Input: arr[] = [3, 34, 4, 12, 5, 2, target = 30
//Output: false
//Explanation: There is no subset with target sum 30.
//Input: arr[] = [1, 2, 3], sum = 6
//Output: true
//Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
//Constraints:
//        1 <= arr.size() <= 200
//        1<= arr[i] <= 200
//        1<= sum <= 4*104


import java.util.Arrays;

public class SubSetSum {

    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1]; // Use primitive `boolean` to avoid null issues.

        // Initialize the dp array
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; // Any subset can achieve sum 0 (by taking no elements).
        }

        if (arr[0] <= target) {
            dp[0][arr[0]] = true; // If the first element can achieve a sum, set it to true.
        }

        for (int ind = 1; ind < n; ind++) {
            for (int k = 1; k <= target; k++) {
                boolean notTaken = dp[ind - 1][k];
                boolean taken = false;
                if (k >= arr[ind]) {
                    taken = dp[ind - 1][k - arr[ind]];
                }
                dp[ind][k] = taken || notTaken;
            }
        }

        return dp[n - 1][target];
    }

    public static Boolean Memo(int arr[], int target) {
      // code here
      int n = arr.length;
      Boolean dp[][] = new Boolean[n][target+1];

      for (Boolean rows[] : dp){
          Arrays.fill(rows,null);
      }
      return MemoUtil(arr,n-1,target,dp);
  }

  public static Boolean MemoUtil(int arr[], int index, int target, Boolean dp[][]){

      if (target == 0) return true;

      if (index == 0) return arr[index] == target;

      if (dp[index][target] != null){
          return dp[index][target];
      }

      boolean notPick = MemoUtil(arr,index-1,target,dp);

      boolean take = false;
      if (arr[index] <= target){
          take = MemoUtil(arr,index-1,target - arr[index],dp);
      }

      return dp[index][target] = take || notPick;
  }
}
