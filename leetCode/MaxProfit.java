package leetCode;
/**
 * MaxProfit
 */
public class MaxProfit {
    // 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

    // 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    
    // 注意你不能在买入股票前卖出股票。
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int maxProfit(int[] prices) {
        if(prices==null)
            return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxValue = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxValue = Math.max(maxValue, prices[i]-minPrice);
        }
        return maxValue;
    }

//  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //采用画图的波动法比较简单
    public int maxProfit2(int[] prices){
        //第一个点不能成为波峰，最后一个点不能成为波谷
        int profit = 0;

    for(int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i -1]) {
            profit  = profit + prices[i] - prices[i - 1];
        }
    }

    return profit;
    }

}