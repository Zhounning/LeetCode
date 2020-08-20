package leetCode;

/**
 * subarraysWithKDistinct
 */
public class subarraysWithKDistinct {

    public int SubarraysWithKDistinct(int[] A, int K) {
        if (A == null || A.length < K) {
            return 0;
        }
        // 这个因为有限制条件1 <= A[i] <= A.length
        int[] hash = new int[A.length + 1];
        int l = 0, results = 0, count = 0, result = 1;
        for (int r = 0; r < A.length; r++) {
            hash[A[r]]++;
            if (hash[A[r]] == 1) {
                count++;
            }

            while (hash[A[l]] > 1 || count > K) {
                if (count > K) {
                    result = 1;
                    count--;
                } else {
                    result++;
                }
                hash[A[l]]--;
                l++;
            }

            if (count == K) {
                results += result;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        subarraysWithKDistinct s = new subarraysWithKDistinct();
        int[] A = { 1, 2, 2, 1 };
        int k = 2;
        System.out.println(s.SubarraysWithKDistinct(A, k));
    }
}