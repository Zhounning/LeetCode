package leetCode;

/**
 * SortColors
 */
public class sortColors {
    //
    public void SortColors(int[] nums) {
        int []count = new int[3];

        for (int i : nums) {
            switch (i) {
                case 0:
                    count[0]++;
                    break;
                case 1:
                    count[1]++;
                    break;
                case 2:
                    count[2]++;
                    break;
                default:
                    break;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            
            if(i<count[0])
                nums[i] = 0;
            else if(i< (count[0]+count[1]))
                nums[i] = 1;
            else
                nums[i]=2;
        }
    }

    //使用双指针只需要遍历一次
    public  void SortColors2(int[] nums) {
        int p1=0;
        int curent = 0;
        int p2 = nums.length - 1;

        while (curent<=p2) {
            
            if (nums[curent]==0) {
                swap(nums, curent, p1);
                p1++;
                curent++;
            }else if (nums[curent]==2) {
               swap(nums,curent,p2);
                p2--;
                //这里注意curent不需要++
            }else{
                curent++;
                //因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位，
                //而与p2交换的值，curr未扫描，要停下来扫描一下，所以curr不用++。
            }   
        }
    }

    void swap(int[]array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int []nums = {2,0,2,1,1,0};
    }
}