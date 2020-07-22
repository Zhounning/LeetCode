package leetCode;

import java.util.Arrays;

public class numDistinct {
    public int NumDistinct(String s, String t) {
        // if(s==null || s.length()==0)return 0;       
        // if(t==null || t.length()==0)return 0;
        
        int m = s.length();
        int n = t.length();
        // 将 t作为行，s作为列
        int [][]dp = new int[n+1][m+1];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i <=n; i++) {
            for (int j = i; j <=m; j++) {
                dp[i][j] = s.charAt(j-1)==t.charAt(i-1) ?   dp[i][j-1] + dp[i-1][j-1] : dp[i][j-1];
            }
        }

        return dp[n][m];
    }




    public static void main(String[] args) {
        numDistinct n =new numDistinct();
        String s="rabbbit" ;
        String t= "rabbit";
        System.out.println(n.NumDistinct(s, t));
    }
}