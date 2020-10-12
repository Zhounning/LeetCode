package leetCode.lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * generateParenthesis
 */
public class generateParenthesis {
    /****
     * 以‘（’为边界
     */
    public List<String> generateParenthesis(int n) {
        char[] arr = new char[2*n];
        Arrays.fill(arr,')');
        dfs(arr,0,0);
        return ans;
    }
    List<String> ans = new ArrayList<>();
    
    /***
    *
    *
    * n为剩余多少个
    */
    void dfs(char[] arr,int i,int n){
        if(n==arr.length/2){
            ans.add(new String(arr));
            return;
        }

        for(int j=i;j<=2*n;j++){
            arr[j] = '(';
            dfs(arr,j+1,n+1);
            arr[j] = ')';
        }
    }

    public static void main(String[] args) {
        generateParenthesis g = new generateParenthesis();
        System.out.println(g.generateParenthesis(3));
    }
}