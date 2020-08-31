package leetCode;

/**
 * containsPattern
 */
public class containsPattern {

    public boolean ContainsPattern(int[] arr, int m, int k) {
        if (arr.length < m * k) {
            return false;
        }

        int[] temp = new int[m];
        int start = 0;
        while (start < arr.length - m) {

            for (int i = 0; i < m; i++) {
                temp[i] = arr[start + i];
            }

            int count = 1;
            boolean flag = false;
            for (int i = start + m; i < arr.length; i += m) {
                for (int j = 0; j < m; j++) {
                    if (i + j >= arr.length || temp[j] != arr[i + j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                count++;

                if (count == k) {
                    return true;
                }
            }
            start++;
        }
        return false;
    }

    public static void main(String[] args) {
        containsPattern c = new containsPattern();
        int[] arr = { 2, 2 };
        int m = 1;
        int k = 2;
        System.out.println(c.ContainsPattern(arr, m, k));
    }
}