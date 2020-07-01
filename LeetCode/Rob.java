package leetCode;
/**
 * Rob
 */
public class Rob {

    // 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

    // 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/house-robber
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //经典题目 打家劫舍
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];

        int res = Math.max(nums[0], nums[1]);
        int [] dp = new int[nums.length];
        dp[0] = nums[0];    //表示当前最大值
        boolean tag =false;
        if(nums[1]>nums[0]){
            dp[1] = nums[1];
            tag =true;  //因为1是被拿的
        }else{
            dp[1]=dp[0];
            tag = false;
        }
        

        for (int i = 2; i < nums.length; i++) {
            if(tag){
                if(dp[i-1]<dp[i-2]+nums[i]){
                    dp[i] = dp[i-2]+nums[i];
                    tag =true;
                }else{
                    dp[i] = dp[i-1];
                    tag = false;
                }
            }else{
                //说名i-1没有被偷
                dp[i] = dp[i-1]+nums[i];
                tag =true;
            }
            
            res=Math.max(dp[i], res);
        }

        return res;
    }

    public int rob2(int[] nums){
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];
        
        //int res = 0;加两个位置让dp活起来
        int [] dp = new int[nums.length+2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }

        return dp[nums.length + 1];
    }

    public int rob3(int[] nums){
        
        int a = 0;//代表 i-2
        int b = 0;//代表 i-1

        for (int i = 0; i < nums.length; i++) {
            int temp = b;
            // dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
            b = Math.max(a+nums[i], b);
            a =temp;
        }

        return b;
    }

    public static void main(String[] args) {
        int [] nums = {2,1,1,2};
        Rob rob = new Rob();
        System.out.println(rob.rob(nums));
    }
}