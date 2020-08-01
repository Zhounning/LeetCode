package leetCode;

public class maxProfit {
    public int MaxProfit(int[] prices) {
        if (prices == null)
            return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxNum = 0;

        for (int i = 0; i < prices.length; i++) {

            minPrice = Math.min(minPrice, prices[i]);
            maxNum = Math.max(maxNum, prices[i] - minPrice);
        }
        return maxNum;
    }
}