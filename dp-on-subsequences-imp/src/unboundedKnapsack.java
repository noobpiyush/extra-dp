public class unboundedKnapsack {

    public static int knapSack(int val[], int wt[], int capacity) {
        // code here
    }

    public static int Memo(int val[], int wt[], int index, int capacity, int dp[][]){

        if (index == 0){
            return ((int) capacity/wt[0]) * val[0];
        }

        if (capacity < 0) return Integer.MIN_VALUE;

        if (dp[index][capacity] != -1) return dp[index][capacity];

        int notTake = 0 + Memo(val,wt,index-1,capacity,dp);

        int take = Integer.MIN_VALUE;

        if (capacity >= wt[index]){

            take = val[index] + Memo(val,wt,index,capacity - wt[index],dp);
        }

        return dp[index][capacity] = Math.max(take,notTake);

    }

    public static int Tab(int wt[], int val[], int capacity){

        int n = wt.length;
        int dp[][] =  new int[n][capacity+1];
        for (int w = 0;w<=capacity;w++){
            dp[0][w] = ((int) w/wt[0]) * val[0];
        }

        for (int index = 1;index<n;index++){
            for (int w = 1;w<=capacity;w++){
                int notTake = 0 + dp[index-1][w];

                int take = Integer.MIN_VALUE;

                if (w >= wt[index]){

                    take = val[index] + dp[index][w -wt[index]];
                }

                dp[index][w] =  Math.max(take,notTake);
            }
        }

        return dp[n-1][capacity];
    }
}
