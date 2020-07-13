package leetCode;

public class minPathSum {
    // 二维
    public int MinPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0) {
                    dp[i][j] = grid[i][j];            
                }else if(i==0){
                    dp[i][j] = dp[0][j-1]+grid[0][j];
                }else if(j==0){
                    dp[i][j] = dp[i-1][0]+grid[i][0];
                }else{
                    dp[i][j] = grid[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    //一维
    public int MinPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int []dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0) {
                    dp[j] = grid[i][j];            
                }else if(i==0){
                    dp[j] = dp[j-1]+grid[0][j];
                }else if(j==0){
                    dp[j] = dp[j]+grid[i][0];
                }else{
                    dp[j] = grid[i][j]+Math.min(dp[j],dp[j-1]);
                }
            }
        }
        return dp[n-1];
    
    }

    public static void main(String[] args) {
        minPathSum m =new minPathSum();
        int[][] grid = new int[][]{
            new int[]{1,2,5},
            new int[]{3,2,1}
        };
        System.out.println(m.MinPathSum2(grid));
    }
}