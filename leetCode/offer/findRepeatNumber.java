package leetCode.offer;

public class findRepeatNumber {
    public int FindRepeatNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                int j = nums[i];
                if(nums[j]==j){
                    return j;
                }
                nums[i] = nums[j];
                nums[j] = j;

            } else {
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        findRepeatNumber f = new findRepeatNumber();
        int[] nums = { 2, 3, 1, 0, 2, 5, 3 };
        System.out.println(f.FindRepeatNumber(nums));
    }
}