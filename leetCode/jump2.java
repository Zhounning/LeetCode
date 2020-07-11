package leetCode;

public class jump2 {
    public int Jump(int[] nums) {
        if(nums==null)return 0;
        //思想：尽量一次跳的远一些
        //maxLength表示目前最远能到，curentLength表示从上次起跳最远能到
        int maxLength = 0,curentLength = 0,count=0;

        for (int i = 0; i < nums.length; i++) {
            //表示从上次起跳的位置已经到达不了这里了，所以需要另外寻找起跳的位置
            if (i>curentLength) {
                count++;
                curentLength = maxLength;
            }
            //最远能到
            if (maxLength<i+nums[i]) {
                maxLength=i+nums[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        jump2 j =new jump2();
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(j.Jump(nums));
    }
}