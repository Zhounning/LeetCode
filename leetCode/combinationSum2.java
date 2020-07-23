package leetCode;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
/**
 * CombinationSum2
 * 2020-07-07 重做
 */
public class combinationSum2 {
    List<List<Integer>> res = null;
    int[] candidates;
    public List<List<Integer>> CombinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        if (candidates!=null&&candidates.length>0) {
            LinkedList<Integer> choose = new LinkedList<>();
            Arrays.sort(candidates);
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
            //大于 index 这个很灵性,需要和大于 0 进行对比
            if (i>index && candidates[i]==candidates[i-1]) {
                continue;
            }

            if (target>=candidates[i]) {
                choose.add(candidates[i]);
                dfs(choose,target-candidates[i],i+1);
                choose.pollLast();
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        combinationSum2 c =new combinationSum2();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(c.CombinationSum2(candidates, target));
    }
}