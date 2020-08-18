package leetCode;

public class minSwaps {
    public int MinSwaps(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // 统计后缀0的个数
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (grid[i][j] != 0) {
                    break;
                }
                a[i]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] >= n - i - 1) {
                // 满足条件,跳过
                continue;
            }
            int j = i + 1;
            for (; j < n; j++) {
                if (a[j] >= n - i - 1)
                    break;
            }
            if (j == n)
                return -1; // 找不到，直接返回-1
            for (; j > i; j--) // 找到了最先满足条件的后缀0个数
            {

                int temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
                count++; // 记录交换次数
            }

        }
        return count;
    }

    public static void main(String[] args) {
        minSwaps m = new minSwaps();
        int[][] grid = { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(m.MinSwaps(grid));
    }
}