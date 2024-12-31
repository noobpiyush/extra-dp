import java.util.Arrays;

public class PartitionswithGivenDifference {

    public static int countPartitions(int[] arr, int d) {
        // code here
        int totSum = 0;

        for(int sum:arr){
            totSum+=sum;
        }

        if(totSum - d < 0) return -1;

        if((totSum - d) % 2 != 0) return -1;

        int s2 = (totSum -d )/2;

        int dp[][] = new int[arr.length][s2 + 1];

        for (int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        return partitonWithGivenDiff(arr.length-1,s2,arr,dp);

    }

    public static int partitonWithGivenDiff(int index, int target, int arr[], int dp[][]){
        if (index == 0) {
            if (target == 0 && arr[index] == 0) return 2;

            if (target == 0 || target == arr[0]) return 1;

            return 0;
        }

        if (dp[index][target] != -1) return dp[index][target];

        int notTake = partitonWithGivenDiff(index-1,target,arr,dp);

        int take = 0;

        if (target >= arr[index]){
            take = partitonWithGivenDiff(index-1,target-arr[index],arr,dp);
        }

        dp[index][target] = take + notTake;

        return dp[index][target];
    }


}
