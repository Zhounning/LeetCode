package leetCode;

public class longestCommonPrefix {
    public String LongestCommonPrefix(String[] strs) {
        if(strs==null||strs.length<=0)return "";
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            boolean isDiff = false; //判断前几个是否相等
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length()<=i||strs[j].charAt(i)!=ch) {
                    isDiff = true;
                    break;
                }
            }
            if (isDiff) {
                break;
            }
            res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        longestCommonPrefix l = new longestCommonPrefix();
        String[] strs = {"flo","fl","fl"};
        System.out.println(l.LongestCommonPrefix(strs));
    }
}