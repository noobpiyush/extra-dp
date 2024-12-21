import java.util.Arrays;

public class NinjasTraining {

    public static int maximumPoints(int arr[][], int n) {
        // code here

        int dp[][] = new int[n][4];

        for (int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        return memoHelper(n-1,3,arr,dp);
    }

    public static int memoHelper(int day, int last,int arr[][], int dp[][]){

        if (dp[day][last] != -1){
            return dp[day][last];
        }

        if (day == 0){
            int maxi = 0;
            for (int i =0;i<=2;i++){
                if (i != last){
                    maxi = Math.max(maxi,arr[0][i]);
                }
            }

            return dp[day][last] = maxi;
        }

        int maxi = 0;

        for (int i =0;i<=2;i++){
            if (i != last){
                int activity = arr[day][i] + memoHelper(day,i,arr,dp);
                maxi = Math.max(maxi,activity);
            }
        }

        return dp[day][last] = maxi;
    }

    public static int Tab(int arr[][], int n){
        int dp[][] = new int[n][4];

        dp[0][0] = Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][2],arr[0][0]);
        dp[0][2] = Math.max(arr[0][1],arr[0][0]);

        dp[0][3] = Math.max(arr[0][0],Math.max(arr[0][1], arr[0][2]));

        for (int day = 1; day < n; day++){
            for (int last  = 0; last < 4;last++){
                dp[0][0] = 0;

                for (int activity = 0; activity<= 2;activity++){
                    if (activity != last){
                        int points = arr[day][activity] + dp[day-1][last];
                    }
                }
            }
        }

        return -1;
    }
}
