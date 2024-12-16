public class Maximum_Non_Negative_Product_in_a_Matrix {

    public static int MOD = 1000000007;

    public static int maxProductPathMemo(int[][] grid) {

        int n  = grid.length;;

        int m = grid[0].length;

        return MemoUtil(grid,n-1,m-1);
    }

    public static int MemoUtil(int grid[][], int i, int j){

        if (i == 0 && j == 0){
            return grid[i][j] >= 0 ? grid[i][j] % MOD : -1;
        }

        if (i < 0 || j < 0) return -1;

        int up = ((grid[i][j] % MOD) * MemoUtil(grid,i-1,j)%MOD) % MOD;

        int down = ((grid[i][j] % MOD) * MemoUtil(grid, i, j-1)%MOD) % MOD;

        int max = Math.max(up,down);

        return max >= 0 ? max : -1;
    }

    public static void main(String[] args) {
        int [][] grid = {{1,-2,1},{1,-2,1},{3,-4,1}};

        System.out.println(maxProductPathMemo(grid));

    }
}
