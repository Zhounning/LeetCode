package leetCode;

import java.util.Arrays;

/***
 * 5496
 */
public class maxCoins2 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int a = piles.length / 3;
        int ans = 0;
        int i = piles.length - 2;
        while (a != 0) {
            ans += piles[i];
            a--;
            i = i - 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        maxCoins2 m = new maxCoins2();
        int[] piles = { 9, 8, 7, 6, 5, 1, 2, 3, 4 };
        System.out.println(m.maxCoins(piles));
    }
}