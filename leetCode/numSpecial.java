package leetCode;

/**
 * numSpecial
 */
public class numSpecial {

    public int NumSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        // 代表第一行
        int[] row = new int[m];
        // 代表第一列
        int[] col = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    row[j]++;
                    col[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (row[i] == 1) {
                int f = 0;
                for (int j = 0; j < n; j++) {
                    if (mat[j][i] == 1) {
                        if (col[j] == 1) {
                            f++;
                        } else {
                            f += 2;
                        }
                    }
                }
                if (f == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        numSpecial n = new numSpecial();
        // int[][] mat = { { 0, 0, 0, 1 }, { 1, 0, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
        // int[][] mat = { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
        int[][] mat = { { 0, 0 }, { 0, 0}, { 1, 0 } };
        System.out.println(n.NumSpecial(mat));
    }
}