package leetCode.offer;

public class printNumbers {
    public int[] PrintNumbers(int n) {
        int x = (int) Math.pow(10, n);
        int[] ans = new int[x - 1];
        for (int i = 1; i < x; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }
}