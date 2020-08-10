package leetCode;

public class numSub {
    public int NumSub(String s) {
        long res = 0;
        int mod = 1000000007;
        long count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                // 说明数字等于0，开始计算
                res += (((count + 1) * count)%mod) / 2;
                res = res % mod;
                count = 0;
            }
        }
        res += (((count + 1) * count)%mod) / 2;
        res = res % mod;
        return  (int)res;
    }

    public static void main(String[] args) {
        numSub n = new numSub();
        String s = "101";
        System.out.println(n.NumSub(s));
    }
}