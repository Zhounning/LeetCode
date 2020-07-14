package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class combine {
    List<List<Integer>> res = new LinkedList<>();
    int k;
    int []nums;
    public List<List<Integer>> Combine(int n, int k) {
        nums = new int[n];
        this.k=k;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        LinkedList<Integer> path = new LinkedList<>();
        dfs(path,0);
        return res;
    }

    void dfs(LinkedList<Integer> path,int n){
        if (path.size()==k) {
            res.add(new LinkedList(path));
            return ;
        }

        for (int i = n; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(path,i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        combine c =new combine();
        int n=4;
        int k=2;
        System.out.println(c.Combine(n, k));
    }
}