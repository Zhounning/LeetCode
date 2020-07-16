package leetCode;

public class numDecodings {
    //跟爬楼梯相同
    public int NumDecodings(String s) {
        if (s==null||s.length()==0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len];
        //这个0好烦啊
        char[] charArray = s.toCharArray();
        if (charArray[0] == '0') {
            return 0;
        }

        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            if (charArray[i] != '0') {
                dp[i] = dp[i - 1];
            }
            int num = 10 * (charArray[i - 1] - '0') + (charArray[i] - '0');
            if (num>=10 && num<=26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        numDecodings n =new numDecodings();
        String s = "01";
        System.out.println(n.NumDecodings(s));
    }
}