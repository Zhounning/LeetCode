package leetCode.offer;

public class twoSum60 {
    public double[] twoSum(int n) {
        double[] pre = { 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d };
        for (int i = 2; i <= n; i++) {
            // 从1*i开始到i*6个
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++)
                for (int x = 0; x < 6; x++)
                    tmp[j + x] += pre[j] / 6;// 乘以这个筛子的1/6（六分之一）
            pre = tmp;
        }
        return pre;
    }
}