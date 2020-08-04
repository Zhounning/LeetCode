package leetCode;

import java.util.Arrays;

public class hIndex {
    public int HIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                h = n - i;
                break;
            }
        }

        return h;
    }

    public static void main(String[] args) {
        hIndex h = new hIndex();
        int[] citations = { 2, 0, 6, 1, 5 };
        System.out.println(h.HIndex(citations));
    }
}