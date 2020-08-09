package leetCode;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {

    List<String> res = null;

    /****** 第一种方法：以 ')'为边界 */
    public List<String> GenerateParenthesis(int n) {
        res = new ArrayList<>();
        char[] Parenthesis = new char[2 * n];
        // 先把所有的赋值为 '（'，然后再填写')''
        for (int i = 0; i < Parenthesis.length; i++) {
            Parenthesis[i] = '(';
        }
        dfs(Parenthesis, 1, 0);
        return res;
    }

    void dfs(char[] Parenthesis, int index, int count) {
        if (count == Parenthesis.length / 2) {
            res.add(String.valueOf(Parenthesis));
            return;
        }

        for (int i = index; i < Parenthesis.length; i++) {
            // 理解为前面（的数量不得小于）的数量
            // i为（填写的位置，count+1表示第几个（
            // eg：填写第2个(时，他最小的位置为3（从0开始），因为前面最少要有2个（，不然不合理
            // 所以 i+1 表示第几个元素，这个元素位置得大于等于括号数量×2
            if (i + 1 < (count + 1) * 2)
                continue;
            Parenthesis[i] = ')';
            dfs(Parenthesis, i + 1, count + 1);
            Parenthesis[i] = '(';
        }
    }

    public static void main(String[] args) {
        generateParenthesis g = new generateParenthesis();
        System.out.println(g.GenerateParenthesis(3));
    }
}