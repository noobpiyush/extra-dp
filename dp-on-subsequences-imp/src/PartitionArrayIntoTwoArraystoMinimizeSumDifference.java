////You are given an integer array nums of 2 * n integers. You need to partition nums into two arrays of length n to minimize the absolute difference of the sums of the arrays. To partition nums, put each element of nums into one of the two arrays.
////
////Return the minimum possible absolute difference.
////Example 1:
////
////example-1
////Input: nums = [3,9,7,3]
////Output: 2
////Explanation: One optimal partition is: [3,9] and [7,3].
////The absolute difference between the sums of the arrays is abs((3 + 9) - (7 + 3)) = 2.
////Example 2:
////
////Input: nums = [-36,36]
////Output: 72
////Explanation: One optimal partition is: [-36] and [36].
////The absolute difference between the sums of the arrays is abs((-36) - (36)) = 72.
////Example 3:
////
////example-3
////Input: nums = [2,-1,0,4,-2,-9]
////Output: 0
////Explanation: One optimal partition is: [2,4,-9] and [-1,0,-2].
////The absolute difference between the sums of the arrays is abs((2 + 4 + -9) - (-1 + 0 + -2)) = 0.
//
//public class PartitionArrayIntoTwoArraystoMinimizeSumDifference {
//
//    public static void main(String[] args) {
//        int arr[] = {-36,36};
//
//        System.out.println(minimumDifference(arr));
//
//        System.out.println(rec(arr,0,));
//    }
//
//    public static boolean rec(int nums[], int target, int index){
//        if (target == 0) return true;
//
//        if (index  == 0) return nums[0] == target;
//
//        boolean notPick = rec(nums,target,index-1);
//
//        boolean pick = false;
//        if (target >= nums[index]){
//            pick = rec(nums,target- nums[index], index-1);
//        }
//
//        return pick || notPick;
//    }
//
//    public static int minimumDifference(int[] nums) {
//        int n = nums.length;
//
//        // Step 1: Find minimum value and adjust for negatives
//        int minValue = Integer.MAX_VALUE;
//        int totSum = 0;
//
//        for (int num : nums) {
//            totSum += num;
//            minValue = Math.min(minValue, num);
//        }
//
//        if (minValue < 0) {
//            // Adjust all elements to be non-negative
//            for (int i = 0; i < n; i++) {
//                nums[i] += Math.abs(minValue);
//            }
//            // Recompute the total sum after adjustment
//            totSum = 0;
//            for (int num : nums) {
//                totSum += num;
//            }
//        }
//
//        // Step 2: Initialize DP table
//        boolean[][] dp = new boolean[n + 1][totSum + 1];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = true; // Subset sum of 0 is always possible
//        }
//
//        // Step 3: Fill DP table
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= totSum; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (nums[i - 1] <= j) {
//                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
//                }
//            }
//        }
//
//        // Step 4: Find minimum difference
//        int mini = Integer.MAX_VALUE;
//        for (int s1 = 0; s1 <= totSum / 2; s1++) {
//            if (dp[n][s1]) {
//                mini = Math.min(mini, Math.abs(totSum - 2 * s1));
//            }
//        }
//
//        return mini;
//    }
//
//}
