package leetCode;

public class isMatch {

    char[] str;
    char[] pattern;

    // 使用递归完成,能通过但是比较浪费时间
    public boolean IsMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        this.str = s.toCharArray();
        this.pattern = p.toCharArray();
        return matchCore(0, 0);
    }

    /***
     * 
     * @param sStart str 开始的位置
     * @param pStart pattern 开始的位置
     * @return
     */
    boolean matchCore(int sStart, int pStart) {
        if (sStart == str.length && pStart == pattern.length)
            return true;
        if (sStart != str.length && pStart == pattern.length)
            return false;

        // 说明第二个为 *
        if (pStart < pattern.length - 1 && pattern[pStart + 1] == '*') {
            if (sStart != str.length && (pattern[pStart] == str[sStart] || pattern[pStart] == '.')) {
                // 相等时，需要进行判断
                // 分别为 *当作一个，当作多个，当作没有
                return matchCore(sStart + 1, pStart + 2) || matchCore(sStart + 1, pStart)
                        || matchCore(sStart, pStart + 2);

            } else {
                // 不相等时，当这个*不存在
                return matchCore(sStart, pStart + 2);
            }
        }

        if (sStart != str.length && (pattern[pStart] == str[sStart] || (pattern[pStart] == '.')))
            return matchCore(sStart + 1, pStart + 1);

        return false;

    }

    // 动态规划
    public boolean IsMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /***
     * 复习重做，使用动态规划
     * 
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch3(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 将 第j、j-1个字符当作空，也就是将 * 和前面一个字符当作空
                    dp[i][j] = dp[i][j - 2];
                    // 判断s的第i个字符 和 p的第j-1个字符是否匹配，也就是判断 * 前面一个字符是否匹配
                    if (matches(s, p, i, j - 1)) {
                        // 分别代表 *号前面的字符出现多次、1次、0次
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                        // 当然也可以写成 dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 2] || dp[i][j - 2]
                    }
                } else if (matches(s, p, i, j)) {
                    // 说明 s中第i个字符 和 p中第j个字符匹配
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        isMatch m = new isMatch();
        String str = "aab";
        String pattern = "c*a*b";
        System.out.println(m.isMatch3(str, pattern));

    }
}