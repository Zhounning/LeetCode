package leetCode;

import java.util.Arrays;

/**
 * finalPrices
 */
public class finalPrices {

    public int[] FinalPrices(int[] prices) {
        int[] res = new int[prices.length];

        for (int i = 0; i < res.length; i++) {
            res[i] = prices[i];

            for (int j = i + 1; j < res.length; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] -= prices[j];
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = { 8, 4, 6, 2, 3 };
        finalPrices f = new finalPrices();
        System.out.println(Arrays.toString(f.FinalPrices(prices)));
    }
}