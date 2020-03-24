import javax.lang.model.util.ElementScanner6;

/**
 * SortColors
 */
public class SortColors {
    // 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

    // 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    
    // 注意:
    // 不能使用代码库中的排序函数来解决这道题。
    
    // 示例:
    
    // 输入: [2,0,2,1,1,0]
    // 输出: [0,0,1,1,2,2]
    // 进阶：
    
    // 一个直观的解决方案是使用计数排序的两趟扫描算法。
    // 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
    // 你能想出一个仅使用常数空间的一趟扫描算法吗？
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/sort-colors
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public void sortColors(int[] nums) {
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
    public static void sortColors2(int[] nums) {
        int p1=0;
        int curent = 0;
        int p2 = nums.length - 1;

        while (curent<=p2) {
            
            if (nums[curent]==0) {
                int temp = nums[p1];
                nums[p1] = nums[curent];
                nums[curent] = temp;
                p1++;
                curent++;
            }else if (nums[curent]==2) {
                int temp = nums[p2];
                nums[p2] = nums[curent];
                nums[curent] = temp;
                p2--;
                //这里注意curent不需要++
            }else{
                curent++;
            }
            
        }
    }

    public static void main(String[] args) {
        int []nums = {2,0,2,1,1,0};
        sortColors2(nums);
    }
}