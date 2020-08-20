package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class numSubmat {
    // 单调栈
    public int NumSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] row = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else if (mat[i][j] != 0) {
                    row[i][j] = row[i][j - 1] + 1;
                } else {
                    row[i][j] = 0;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < m; ++j) {
            int i = 0;
            Deque<int[]> stack = new LinkedList<int[]>();
            int sum = 0;
            while (i <= n - 1) {
                int height = 1;
                while (!stack.isEmpty() && stack.peekLast()[0] > row[i][j]) {
                    // 弹出的时候要减去多于的答案
                    sum -= stack.peekLast()[1] * (stack.peekLast()[0] - row[i][j]);
                    height += stack.peekLast()[1];
                    stack.pollLast();
                }
                sum += row[i][j];
                ans += sum;
                stack.offerLast(new int[] { row[i][j], height });
                i++;
            }
        }
        return ans;
    }

    // 单调栈分成两个部分
    public int NumSubmat2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] row = new int[m];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                row[j] = mat[i][j] == 1 ? row[j] + 1 : 0;
            }
            ans += f(row);
        }
        return ans;
    }

    // 使用单调栈
    int f(int[] row) {
        Deque<int[]> stack = new LinkedList<int[]>();
        int sum = 0;
        int n = row.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int height = 1;
            while (!stack.isEmpty() && stack.peekLast()[0] > row[i]) {
                // 弹出的时候要减去多于的答案
                sum -= stack.peekLast()[1] * (stack.peekLast()[0] - row[i]);
                height += stack.peekLast()[1];
                stack.pollLast();
            }
            sum += row[i];
            ans += sum;
            stack.offerLast(new int[] { row[i], height });
        }
        return ans;
    }

    public static void main(String[] args) {
        numSubmat n = new numSubmat();
        int[][] mat = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(n.NumSubmat2(mat));
    }
}