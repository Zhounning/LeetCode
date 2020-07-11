package leetCode;
import java.util.ArrayList;
import java.util.List;

/**
 * Permute
 * 2020-07-11重写
 */
public class permute {

    List<List<Integer>> res = null;
    public List<List<Integer>> Permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums,0);
        return res;
    }

    void dfs(int[] nums,int index){
        if (index==nums.length) {
            List<Integer> path =new ArrayList<>(nums.length);
            for (Integer integer : nums) {
                path.add(integer);
            }
            res.add(path);
            return ;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums,index,i);
            dfs(nums,index+1);
            swap(nums,index,i);
        }

    }

    void swap(int []array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int []nums = {1,2,3};
        permute p =new permute();
        System.out.println(p.Permute(nums));
       
    }
}