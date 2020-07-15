package leetCode;

public class maximalRectangle {
    public int MaximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int maxarea = 0;
        //dp[i][j] 代表
        int [][]dp = new int[m][n];


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (matrix[i][j] == '1'){
                
                }
            }
        }

        return maxarea;
    }
}