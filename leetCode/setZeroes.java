package leetCode;

import java.util.Arrays;

/**
 * SetZeroes
 * 2020-07-14 重做
 */
public class setZeroes {
   
    public void SetZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean []rows = new boolean [m];
        boolean []cols = new boolean [n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0) {
                    rows[i] = true;
                    cols[j] = true;
                }   
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j]=0;
                }
            }
        }
    }  

    //只用两个变量
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false; // 第一行是否应该全部为0
        boolean firstCol  = false; // 第一列是否应该全部为0

        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                int item = matrix[i][j];
                if (item == 0) {
                  if (i == 0) {
                    firstRow = true;
                  }
                  if (j == 0) {
                    firstCol = true;
                  }
                //   如果item == 0，则将matrix[i][j]对应的第一行和第一列元素设置为0
                  matrix[0][j] = 0;
                  matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 最后处理第一行和第一列
        if (firstRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        setZeroes s = new setZeroes();
        int[][] matrix = new int[][]{
            new int[]{0,1,2,0},
            new int[]{3,4,5,2},
            new int[]{1,3,1,5}
        };

        s.SetZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
           System.out.println( Arrays.toString(matrix[i]));
        }
    }
}