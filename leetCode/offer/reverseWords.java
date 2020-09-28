package leetCode.offer;

public class reverseWords {

    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ')
                i--; // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ')
                i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    void revers(char[] s, int l, int r) {
        int i = l;
        while (i < (l + r) / 2) {
            int j = (l + r) - i;
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
        }
    }
}