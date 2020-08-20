package leetCode;

import java.util.PriorityQueue;

/****
 * 378题
 */
public class kthSmallest2 {
    /****
     * 二分法
     * 
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        // n*n的矩阵
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(matrix, mid, k, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /***
     * 
     * @param matrix
     * @param mid
     * @param k
     * @param n
     * @return mid是否大于第k个数
     */
    boolean check(int[][] matrix, int mid, int k, int n) {
        int cnt = 0;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return cnt >= k;
    }

    /***
     * 归并排序
     * 
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest3(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // 放入int[3]，第一个数代表数字本身，第二个数代表第几行，第三个数代表第几列
            heap.add(new int[] { matrix[i][0], i, 0 });
        }
        int cnt = 0;
        while (cnt < k-1) {
            int[] cp = heap.poll();
            cnt++;
            if (cp[2] < n - 1) {
                heap.offer(new int[] { matrix[cp[1]][cp[2]+1], cp[1], cp[2] + 1 });
            }
        }
        return heap.peek()[0];
    }

    public static void main(String[] args) {
        kthSmallest2 kt = new kthSmallest2();
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        // int[][] matrix = { { 1} };
        int k = 8;
        System.out.println(kt.kthSmallest3(matrix, k));
    }
}