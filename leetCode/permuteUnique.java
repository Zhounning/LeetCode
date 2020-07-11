package leetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * PermuteUnique
 * 2020-07-11 重做
 */
public class permuteUnique {
    List<List<Integer>> res = null;
    public List<List<Integer>> PermuteUnique(int[] nums) {
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

        Set<Integer> vistSet  = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if(!vistSet.contains(nums[i])) {
                vistSet.add(nums[i]);
                swap(nums,index,i);
                dfs(nums,index+1);
                swap(nums,index,i);
            }

        }
    }

    void swap(int []array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int []nums = {1,1,2};
        permuteUnique p =new permuteUnique();
        System.out.println(p.PermuteUnique(nums));
    }
}