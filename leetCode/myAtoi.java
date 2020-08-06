package leetCode;

import java.util.HashMap;

public class myAtoi {
    public int MyAtoi(String str) {
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

    HashMap<String, String[]> stateMap = new HashMap<>();
    {
        stateMap.put("start", new String[] { "signed", "in_number", "end" });
        stateMap.put("signed", new String[] { "end", "in_number", "end" });
        stateMap.put("in_number", new String[] { "end", "in_number", "end" });
        stateMap.put("end", new String[] { "end", "end", "end" });
    }

    String state = "start";
    int sign = 1;
    long ans = 0;

    // 给出状态表第几列
    int get_col(char c) {
        if (c == '+' || c == '-') {
            return 0;
        }

        if (Character.isDigit(c)) {
            return 1;
        }
        return 2;
    }

    void setState(char c) {
        state = stateMap.get(state)[get_col(c)];
        if (state == "in_number") {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if (state == "signed")
            sign = c == '+' ? 1 : -1;
    }

    // 使用状态机进行编程
    public int MyAtoi2(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        String s = str.trim();// 去掉头部空字符
        for (int i = 0; i < s.length(); i++) {
            setState(s.charAt(i));
        }

        return (int) (sign * ans);
    }

    public static void main(String[] args) {
        myAtoi m = new myAtoi();
        String str = "-91283472332";
        System.out.println(m.MyAtoi2(str));
    }
}