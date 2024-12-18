import java.util.Arrays;

public class MinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n+1];
        for (int i =0;i<=n;i++) {
           dp[i] = -1;
        }
        return memo(days, costs, 0, n,dp);
    }

    public static int memo(int days[], int costs[], int index,int n, int dp[]) {

        // Base case: No more days to process
        if (index >= n){
            return 0;

        }

        if (dp[index] != -1) return dp[index];

        int opt1 = costs[0] + memo(days,costs,index+1,n,dp);

        int i;

        //7 day pass
        i = index;
        while (i<n && days[i] < days[index] + 7) {
            i++;
        }

        int opt2 = costs[1] + memo(days,costs,i,n,dp);

        //30 day pass
        while (i<n && days[i] < days[index] + 30) {
            i++;
        }

        int opt3  = costs[2] + memo(days,costs,i,n,dp);

        return dp[index] = Math.min(opt1,Math.min(opt2,opt3));
    }

    public static int Tab(int days[], int costs[]){
        int n = days.length;
        int dp[] = new int[n+1];
        dp[n] = 0;
        for (int i = n-1;i>=0;i--){
            int opt1 = costs[0] + dp[i+1];
            int j;
            for ( j = i;j<n && days[j] < days[i] + 7;j++ );
            int opt2 = costs[1] + dp[j];

            for ( j = i;j<n && days[j] < days[i] + 30;j++ );
            int opt3 = costs[2] + dp[j];

            dp[i] = Math.min(opt1, Math.min(opt2,opt3));
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        MinimumCostForTickets mt = new MinimumCostForTickets();
        System.out.println(mt.mincostTickets(days, costs)); // Expected Output: 11
        System.out.println(Tab(days,costs));
    }
}
