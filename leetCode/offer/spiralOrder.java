package leetCode.offer;

import java.util.Arrays;

public class spiralOrder {
    Integer idx = 0;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0) {
            return new int[]{};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int[] ans = new int[n * m];
        while (start * 2 < n && start * 2 < m) {
            f(start, matrix, ans);
            start++;
        }
        return ans;
    }

    void f(int start, int[][] matrix, int[] ans) {
        int n = matrix.length;
        int m = matrix[0].length;
        int endx = m - start - 1;
        int endy = n - start - 1;

        // 从左到右
        for (int i = start; i <= endx; i++) {
            ans[idx] = matrix[start][i];
            idx++;
        }

        // 从上到下
        if (start < endy) {
            for (int i = start + 1; i <= endy; i++) {
                ans[idx] = matrix[i][endx];
                idx++;
            }
        }

        // 从右到左
        if (start < endy && start < endx) {
            for (int i = endx - 1; i>=start; i--) {
                ans[idx] = matrix[endy][i];
                idx++;
            }
        }
        // 从下向上
        if (start < endy - 1 && start < endx) {
            for (int i = endy - 1; i > start; i--) {
                ans[idx] = matrix[i][start];
                idx++;
            }
        }
    }

    public static void main(String[] args) {
        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder s = new spiralOrder();
        System.out.println(Arrays.toString(s.spiralOrder(matrix)));
    }
}