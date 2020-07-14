package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Subsets
 * 2020-07-14
 */
public class subsets {

    List<List<Integer>> res = new LinkedList<>();
    int [] nums;
    public List<List<Integer>> Subsets(int[] nums) {
        LinkedList<Integer> ans = new LinkedList<>();
        this.nums = nums;
        dfs(ans,0);
        return res;
    }

    void dfs(LinkedList<Integer> ans,int n){
        res.add(new LinkedList(ans));
        for (int i = n; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(ans,i+1);
            ans.removeLast();
        }
    }



    public static void main(String[] args) {
        int [] nums =new int[] {1,2,3};
        subsets s = new subsets();
        System.out.println(s.Subsets(nums));
    }
}