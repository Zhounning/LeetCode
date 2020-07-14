package leetCode;

import java.util.Stack;

/**
 * 这题挺难的，而且感觉有些没有看懂 抄了一个答案放在这里，感觉不会做
 * 原答案链接：https://leetcode-cn.com/problems/simplify-path/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-18/
 */
public class simplifyPath {
    public String SimplifyPath(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/");
            res.append(stack.get(i));
        }
        return res.toString();
    }
}