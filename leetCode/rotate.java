package leetCode;

import java.util.Arrays;

/**
 * Rotate
 * 2020-07-11 重做
 */
public class rotate {
    //其实就是转置,再换行
    public void Rotate(int[][] matrix) {
        if (matrix==null) {
            return;
        }

        int n = matrix.length;//数组的长度 n*n放入矩阵
        //进行转置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        //换列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        rotate r = new rotate();
        int [][]matrix = new int[][]{
            new int[]{1,2,3},
            new int[]{4,5,6},
            new int[]{7,8,9}
        };
        r.Rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
        System.out.println(Arrays.toString(matrix[i]));
            
        }
    }
}