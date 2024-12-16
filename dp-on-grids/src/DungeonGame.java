import java.util.Arrays;

public class DungeonGame {

    public static int calculateMinimumHP(int[][] dungeon) {

        int n = dungeon.length;
        int m = dungeon[0].length;

        int dp[][] = new int[n][m];

        for (int rows[] : dp){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }

        return MemoUtil(dungeon,n,m,0,0,dp);
    }

    public  static int MemoUtil(int dugeon[][],int n, int m, int i ,int j, int dp[][]){

        //base case

        if (i >= n || j >= m )  return Integer.MAX_VALUE;

        if (i == n-1 && j == m-1) return dugeon[i][j] > 0 ? 1 : -dugeon[i][j] + 1;

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int up = MemoUtil(dugeon,n,m,i+1,j,dp);

        int left = MemoUtil(dugeon,n,m,i,j+1,dp);

        int minHealth = Math.min(up,left) - dugeon[i][j];

        return dp[i][j] = minHealth <= 0 ? 1 : minHealth;

    }

    public static int calculateMinimumHPTab(int[][] dungeon) {

        int n = dungeon.length;
        int m = dungeon[0].length;

        int dp[][] = new int[n][m];

        for (int i = n-1;i>=0;i--){
          for(int j= m-1;j>=0;j--){

              if (i == n-1 && j == m - 1){
                  dp[i][j] = dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;;
              }
              else{
                  // Calculate the minimum health required from the cell below and to the right
                  int down = (i + 1 < n) ? dp[i + 1][j] : Integer.MAX_VALUE;
                  int right = (j + 1 < m) ? dp[i][j + 1] : Integer.MAX_VALUE;

                  // Determine the minimum health required from either the down or right direction
                  int minHealth = Math.min(down, right) - dungeon[i][j];
                  dp[i][j] = minHealth <= 0 ? 1 : minHealth;
              }
          }
      }

      return dp[0][0];

    }

    public static void main(String[] args) {
        int dungeon[][] = {{-2,-3,3},{-5,-10,1},{10,30,-5}};

        System.out.println(calculateMinimumHP(dungeon));
    }
}
