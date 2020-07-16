package leetCode;

import java.util.List;

public class restoreIpAddresses {
    public List<String> RestoreIpAddresses(String s) {
        
    }

    void dfs(int index){

    }

    //检查是否合法
    boolean check(String nums){
        Integer num,i,len = nums.length();
        if (len > 3 || len == 0) {
            return false;
        }
        //第一位不能为0
        if (len != 1) {
            if (nums.charAt(0) == '0') {
                return false;
            }
        }
        num = Integer.valueOf(nums);
        if (0 <= num && num <= 255) {
            return true;
        }
    
        return false;
    }
}