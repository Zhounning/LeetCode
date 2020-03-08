/**
 * NextPermutation
 */
public class NextPermutation {
    // 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

    // 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    
    // 必须原地修改，只允许使用额外常数空间。
    
    // 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    // 1,2,3 → 1,3,2
    // 3,2,1 → 1,2,3
    // 1,1,5 → 1,5,1
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/next-permutation
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int i = nums.length - 2;
        //从后向前先找第一个降序。
        while (i>-1 && nums[i+1]<=nums[i]) {
            i--;
        }

        int j = nums.length - 1;
        if(i>-1){
            
            //找到刚好比nums[i]大的数
            while(nums[i]>=nums[j])j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        i++;
        j = nums.length-1;
        //将剩下的数进行逆序，变成小的在前面，便成功
        while (i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

    }

    public static void main(String[] args) {
        int [] nums = {1,1};
        NextPermutation nextPermutation =new NextPermutation();
        nextPermutation.nextPermutation(nums);
    }
}