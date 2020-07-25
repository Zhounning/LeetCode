package leetCode;

import java.util.HashSet;
import java.util.List;

public class wordBreak {

    public boolean WordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //dp[i]表示字符串s的前i个字符能否拆分成wordDict
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);

        for (int i = 1; i <=n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}