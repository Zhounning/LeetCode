package leetCode;

/**
 * 通配符的版本
 */
public class isMatch2 {
    char[] str;
    char[] pattern;
    //使用回溯会超时
    public boolean isMatch(String s, String p) {
        if (s==null||p==null) {
            return false;
        }
        this.str = s.toCharArray();
        this.pattern = p.toCharArray();
        return matchCore(0,0);
    }

    /***
     * 
     * @param sStart str开始的地方
     * @param pStart pattern 开始的位置 
     * @return
     */
    boolean matchCore(int sStart,int pStart){
        if (sStart==str.length && pStart==pattern.length) return true;
        if (sStart!=str.length && pStart==pattern.length) return false;
        // if(sStart>=str.length && pattern[pStart]!='*') return false;

        if(sStart<str.length && pattern[pStart]=='*'){
            //分别为 * 代表空、1个字符、多个字符
            return matchCore(sStart, pStart+1) || matchCore(sStart+1, pStart+1) || matchCore(sStart+1, pStart);
        }else if (sStart<str.length && pattern[pStart]==str[sStart]||(pattern[pStart]=='?')) {
            return matchCore(sStart+1, pStart+1);
        }else if (sStart==str.length && pattern[pStart]=='*') {
            return matchCore(sStart, pStart+1);
        }

        return false;
    }

    //动态规划
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        //dp[i][j表示 s 第i个 到p第j个是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <=n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            }
            else {
                break;
            }
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        isMatch2 m = new isMatch2();
        String str ="acdcb";
        String pattern ="a*c?b";
        System.out.println(m.isMatch2(str, pattern));

    }
}