package leetCode;

public class minInsertions {
    eq
    public int MinInsertions(String s) {
        int leftbrakces = 0;
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            // 计算左括号的数量
            while (i < s.length() && s.charAt(i) == '(') {
                leftbrakces++;
                i++;
            }
            if (i == s.length()) {
                break;
            }

            if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                ++i;
            } else {
                // 加一个右括号
                res++;
            }
            // 如果右括号大于 0，消除一个
            if (leftbrakces > 0) {
                --leftbrakces;
            } else {
                // 加一个右括号
                res++;
            }
            i++;
        }
        res += 2 * leftbrakces;
        return res;
    }

    public static void main(String[] args) {
        minInsertions m = new minInsertions();
        String s = "))())(";
        System.out.println(m.MinInsertions(s));
    }
}