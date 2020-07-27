package leetCode;

/**
 * reverseWords
 */
public class reverseWords {

    public String ReverseWords(String s) {
        if (s == null) {
            return null;
        }
        // 去掉首尾的空格
        s = s.trim();
        StringBuilder res = new StringBuilder();

        int end = s.length();
        int start = s.length() - 1;
        while (start >= 0) {
            // 从后向前找到第一个空格位置
            while (start >= 0 && s.charAt(start) != ' ') {
                --start;
            }
            start = start >= 0 ? start : -1;
            res.append(s.substring(start + 1, end));
            end = start;

            // 跳过空格
            while (start >= 0 && s.charAt(start) == ' ') {
                --start;
            }
            if (start >= 0) {
                res.append(' ');
            }
            end = start + 1;

        }
        return res.toString();
    }

    public static void main(String[] args) {
        reverseWords r = new reverseWords();
        String s = "a good   example";
        System.out.println(r.ReverseWords(s));
    }
}