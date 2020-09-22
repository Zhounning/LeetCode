package leetCode.offer;

/**
 * isMatch
 */
public class isMatch {

    public boolean IsMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 2][j];
                    if (matches(p, s, i - 1, j)) {
                        dp[i][j] = dp[i][j] || dp[i][j - 1];
                    }
                } else if (matches(p, s, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public boolean matches(String p, String s, int i, int j) {
        if (j == 0) {
            return false;
        }
        if (p.charAt(i - 1) == '.') {
            return true;
        }
        return s.charAt(j - 1) == p.charAt(i - 1);
    }

    public static void main(String[] args) {
        isMatch i = new isMatch();
        String s = "aab";
        String p = "c*a*b";
        System.out.println(i.IsMatch(s, p));
    }
}