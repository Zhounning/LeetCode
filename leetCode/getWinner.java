package leetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class getWinner {
    public int GetWinner(int[] arr, int k) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int n = arr.length;

        if (k >= n - 1) {
            Arrays.sort(arr);
            return arr[n - 1];
        } else {
            int count = 0;
            int winNum = arr[0];
            for (int i = 1; i < n; i++) {
                if (winNum < arr[i]) {
                    winNum = arr[i];
                    count = 1;
                } else {
                    ++count;
                }
                if (count == k) {
                    break;
                }
            }
            return winNum;
        }
    }

    public static void main(String[] args) {
        getWinner g = new getWinner();
        int[] arr = { 2, 1, 3, 5, 4, 6, 7 };
        int k = 2;
        System.out.println(g.GetWinner(arr, k));
    }
}