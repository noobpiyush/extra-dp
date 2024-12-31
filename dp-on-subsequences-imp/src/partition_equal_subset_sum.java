import javax.imageio.metadata.IIOMetadataFormat;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

public class partition_equal_subset_sum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i =0;i<n;i++){
            sum+= nums[i];
        }

        if (sum % 2 != 0 ) return false;

        int k = sum/2;

        Boolean dp[][] = new Boolean[n][k+1];

        for (Boolean rows[] : dp){
            Arrays.fill(rows,null);
        }

        return Memoutil(nums,n-1,k,dp);
    }

    public static boolean Memoutil(int nums[],int index, int target, Boolean dp[][]){

        if (target == 0) return true;

        if (index == 0) return nums[index] == target;

        if (dp[index][target] != null){
            return dp[index][target];
        }

        boolean take = Memoutil(nums,index - 1,target,dp);

        boolean notTake = false;

        if (target >= nums[index]){

            notTake = Memoutil(nums,index-1,target - nums[index],dp);
        }

        return dp[index][target] = take || notTake;

    }

    public static boolean Tab(int nums[]){
        int sum = 0;
        int n = nums.length;

        for (int i =0;i<n;i++){
            sum+= nums[i];
        }

        if (sum % 2 != 0) return false;

        int k = sum/2;

        boolean dp[][] = new boolean[n][k+1];

        for (int i =0;i<n;i++){
            dp[i][0] = true;
        }

        if (k >= nums[0]){
            dp[0][nums[0]] = true;
        }

        for (int ind = 1;ind < n;ind++){
            for (int target = 1;target <= k;target++){
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if (target >= nums[ind]){
                    take = dp[ind-1][target - nums[ind]];
                }

                dp[ind][target] = take || notTake;
            }
        }

        return dp[n-1][k];
    }
}
