package leetCode;
/**
 * UniquePaths
 */
public class uniquePaths {

    public static int UniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    //更加节约空间的写法
    public static int uniquePaths2(int m, int n) {
        int []dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j]+=dp[j-1];
            }
        }
        return dp[n-1];

    }

    public static int uniquePaths3(int m, int n) {
        int[] f = new int[n];

        f[0] = 1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j - 1 >= 0 ) {
                    f[j]+=f[j - 1];
                }
            }
        }
        
        return f[n - 1];
    }

    public static void main(String[] args) {
        uniquePaths2(3,2);
    }
}