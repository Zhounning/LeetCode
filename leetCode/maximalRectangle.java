package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class maximalRectangle {
    // 动态规划,不会
    public int MaximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int maxarea = 0;
        // dp[i][j] 代表
        int[][] dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (matrix[i][j] == '1') {

                }
            }
        }

        return maxarea;
    }

    // 使用单调栈
    public int MaximalRectangle2(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int maxarea = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxarea = Math.max(maxarea, LargestRectangleArea(dp));
        }
        return maxarea;
    }

    // 单调栈 + 哨兵 的用法
    int LargestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return heights[0];
        }
        int res = 0;
        int[] newHeights = new int[len + 2];

        System.arraycopy(heights, 0, newHeights, 1, len);
        len += 2;
        Deque<Integer> stack = new ArrayDeque<>(len);

        // 先放入哨兵，在循环里就不用做非空判断
        stack.addLast(0);
        for (int i = 0; i < len; i++) {
            while (newHeights[i] < newHeights[stack.peekLast()]) {
                int curHeight = newHeights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        maximalRectangle m = new maximalRectangle();
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(m.MaximalRectangle2(matrix));
    }
}