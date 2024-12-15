import java.util.Arrays;

public class Unique_PathsIn_a_Grid_Obstacles {

    public static int MOD = 1000000007;

    public static int memoUtil(int n,int m,int i, int j, int grid[][], int dp[][]){

        //down and right rev = up  and left
        if (grid[0][0] == 0) return 0;
        if (i >= 0 && j >= 0 && grid[i][j] == 0) return 0;

        if (i == 0 && j == 0) return 1;

        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int up = memoUtil(n,m,i-1,j,grid,dp) % MOD;

        int left = memoUtil(n,m,i,j-1,grid,dp) % MOD;

        return dp[i][j] = (left + up) % MOD;
    }

    public static int Tab(int n, int m, int grid[][]){

        int dp[][] = new int[n][m];

        dp[0][0] = 1;

        for (int i = 0; i< n; i++){
            for (int j =0;j<m;j++){
                if (i == 0 && j == 0) continue;

                int up = i > 0 && grid[i][j] != 0 ? dp[i-1][j] % MOD : 0;

                int left = j > 0 && grid[i][j] != 0 ? dp[i][j-1] % MOD : 0;

                dp[i][j] = (up + left) % MOD;
            }
        }

        return dp[n-1][m-1];
    }

    public static int uniquePaths(int n, int m, int[][] grid) {
        if (grid[0][0] == 0) return 0;
        // code here
        int dp[][] = new int[n][m];

        for (int rows[] : dp){
            Arrays.fill(rows,-1);
        }

        return memoUtil(n,m,n-1,m-1,grid,dp);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int n = maze.length;
        int m = maze[0].length;

        System.out.println(uniquePaths(n,m,maze));

        System.out.println(Tab(n,m,maze));
    }

}

