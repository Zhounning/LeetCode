package leetCode;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {
    List<String> res = null;
    public List<String> GenerateParenthesis(int n) {
         res = new ArrayList<>();
        char [] Parenthesis = new char[2*n];
        for (int i = 0; i < Parenthesis.length; i++) {
            Parenthesis[i]='(';
        }
        dfs(Parenthesis,1,0);
        return res;
    }

    void dfs(char[] Parenthesis,int index,int count){
        if (count==Parenthesis.length/2) {
            res.add(String.valueOf(Parenthesis));
            return;
        }

        for (int i = index; i < Parenthesis.length; i++) {
            if (i+1<(count+1)*2) continue;
            Parenthesis[i] = ')';
            dfs(Parenthesis,i+1,count+1);
            Parenthesis[i]='(';
        }
    }

    public static void main(String[] args) {
        generateParenthesis g =new generateParenthesis();
        System.out.println(g.GenerateParenthesis(3));
    }
}