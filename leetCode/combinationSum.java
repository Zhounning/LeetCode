package leetCode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * CombinationSum
 * 2020-07-07重做
 */
public class combinationSum {
    List<List<Integer>> res = null;
    int[] candidates;
    public List<List<Integer>> CombinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        if (candidates!=null&&candidates.length>0) {
            LinkedList<Integer> choose = new LinkedList<>();
            this.candidates = candidates;
            dfs(choose,target,0);
        }
        return res;
    }

    void dfs(LinkedList<Integer> choose,int target,int index){
        if (target==0) {
            res.add(new LinkedList(choose));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target>=candidates[i]) {
                choose.add(candidates[i]);
                dfs(choose,target-candidates[i],i);
                choose.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        combinationSum c =new combinationSum();
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(c.combinationSum(candidates, target));
    }
}