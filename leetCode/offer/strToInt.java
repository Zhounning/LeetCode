package leetCode.offer;

public class strToInt {
    public int strToInt(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        long res = 0;
        String s = str.trim();// 去掉头部空字符
        if (s.length() > 0) {
            char[] chars = s.toCharArray();
            int start = 0;
            boolean isPositive = true;
            if (chars[0] == '+') {
                isPositive = true;
                start = 1;
            } else if (chars[0] == '-') {
                isPositive = false;
                start = 1;
            }
            for (int i = start; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    res = res * 10 + chars[i] - '0';
                    if (res > Integer.MAX_VALUE) {
                        return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }

            if (!isPositive) {
                res = 0 - res;
            }
        }
        return (int) res;
    }
}