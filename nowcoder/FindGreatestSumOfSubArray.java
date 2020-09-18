package nowcoder;

/**
 * FindGreatestSumOfSubArray
 */
public class FindGreatestSumOfSubArray {

    public int findGreatestSumOfSubArray(int[] array) {

        int dp = array[0];
        int res = dp;
        for (int i = 1; i < array.length; i++) {
            dp = Math.max(array[i], array[i] + dp);
            res = Math.max(dp, res);
        }
        return res;

    }
}