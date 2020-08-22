package lintcode;

public class backPack {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int BackPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length <= 0 || m <= 0) {
            return 0;
        }

        int[] dp = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = dp.length - 1; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {
        backPack b = new backPack();
        int m = 10;
        int[] A = { 3, 4, 8, 5 };
        System.out.println(b.BackPack(m, A));
    }
}