package leetCode;

public class isMatch {

    char[] str;
    char[] pattern;
    //使用递归完成,能通过但是比较浪费时间
    public boolean IsMatch(String s, String p) {
        if (s==null||p==null) {
            return false;
        }
        this.str = s.toCharArray();
        this.pattern = p.toCharArray();
        return matchCore(0,0);
    }

    /***
     * 
     * @param sStart str 开始的位置
     * @param pStart pattern 开始的位置
     * @return
     */
    boolean matchCore(int sStart,int pStart){
        if (sStart==str.length && pStart==pattern.length) return true;
        if (sStart!=str.length && pStart==pattern.length) return false;

        //说明第二个为 *
        if (pStart<pattern.length-1 && pattern[pStart+1]=='*') {
            if (sStart!=str.length && (pattern[pStart]==str[sStart]||pattern[pStart]=='.')) {
                //相等时，需要进行判断
                //分别为 *当作一个，当作多个，当作没有
                return matchCore(sStart+1, pStart+2)||matchCore(sStart+1, pStart) || matchCore(sStart, pStart+2);
                
            }else{
                //不相等时，当这个*不存在
                return matchCore(sStart, pStart+2);
            }
        }

        if (sStart!=str.length && (pattern[pStart]==str[sStart]||(pattern[pStart]=='.' )))
            return matchCore(sStart+1, pStart+1);

        return false;

    }


    //动态规划
    public boolean IsMatch2(String s, String p){
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
                }
                else {
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






























































    

    public static void main(String[] args) {
        isMatch m = new isMatch();
        String str ="aab";
        String pattern ="c*a*b";
        System.out.println(m.IsMatch2(str, pattern));

    }
}