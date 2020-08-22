package leetCode;

/***
 * 1482题
 */
public class minDays2 {

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int ans = -1;
        int l = 0, r = 1000000000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(bloomDay, m, k, mid)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    /****
     * 判断第target是否能行
     * 
     * @param bloomDay
     * @param m
     * @param k
     * @param target
     * @return
     */
    boolean check(int[] bloomDay, int m, int k, int target) {
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < bloomDay.length; i++) {

            if (bloomDay[i] <= target) {
                j++;
            } else {
                j = 0;
            }
            if (j == k) {
                j = 0;
                cnt++;
            }
        }
        return cnt >= m;
    }

    public static void main(String[] args) {
        minDays2 mi = new minDays2();
        int[] bloomDay = { 1, 10, 2, 9, 3, 8, 4, 7, 5, 6 };
        int m = 4;
        int k = 2;
        System.out.println(mi.minDays(bloomDay, m, k));
    }
}