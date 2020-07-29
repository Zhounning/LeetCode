package leetCode;

public class countPrimes {
    // 厄拉多塞筛法
    public int CountPrimes(int n) {
        int result = 0;
        boolean[] b = new boolean[n]; // 初始化默认值都为 false，为质数标记
        if (2 < n)
            result++; // 如果大于 2 则一定拥有 2 这个质数

        for (int i = 3; i < n; i += 2) { // 从 3 开始遍历，且只遍历奇数
            if (!b[i]) { // 是质数
                for (int j = 3; i * j < n; j += 2) {
                    b[i * j] = true; // 将当前质数的奇数倍都设置成非质数标记 true
                }
                result++; // 质数个数 +1
            }
        }
        return result;
    }
}