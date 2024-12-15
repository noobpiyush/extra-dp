import java.util.ArrayList;
import java.util.Arrays;

public class TrianglePathSum {

    public static int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        // Code here
        int n = triangle.size();

        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return memoUtil(triangle,dp,n,0,0);
    }

    public static int memoUtil(ArrayList<ArrayList<Integer>> mat,int dp[][],int n, int i, int j){
        if (i == n -1) return mat.get(n-1).get(j);

        if (dp[i][j] != -1) return dp[i][j];

        int down =  mat.get(i).get(j) + memoUtil(mat,dp,n,i+1,j);

        int diagonal =  mat.get(i).get(j) + memoUtil(mat,dp,n,i+1,j+1);

        return dp[i][j] =  Math.min(diagonal,down);
    }

    public static int Tab(ArrayList<ArrayList<Integer>> triangle){
        int n = triangle.size();

        int dp[][] = new int[n][n];

        for (int j = 0; j < n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for (int i = n-2;i>=0;i--){
            for(int j = i;j>= 0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j]  = Math.min(diag,down);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
