package leetCode.offer;

public class constructArr {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}