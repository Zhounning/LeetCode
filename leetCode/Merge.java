package leetCode;
import java.util.ArrayList;
import java.util.List;

/**
 * Merge
 */
public class Merge {
    // 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

    // 说明:
    
    // 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    // 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    // 示例:
    
    // 输入:
    // nums1 = [1,2,3,0,0,0], m = 3
    // nums2 = [2,5,6],       n = 3
    
    // 输出: [1,2,2,3,5,6]
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/merge-sorted-array
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // for(int i=m,j=0;i<m+n;i++,j++){
        //     nums1[i] = nums2[j];
        // }
        //使用双指针
        int i=0;
        int j=0;
        while(i<j+m&&j<n){

            if(nums1[i]>nums2[j]){
                for(int k=j+m;k>=i+1;k--){
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;   
            }
            i++;
        }

        for(;j<n;j++,i++){
            nums1[i]=nums2[j];
        }
    }

    //相比于上面的双指针后面这种更加优秀，为标答妙哉
    public void merge2(int[] nums1, int m, int[] nums2, int n){


        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;

        while (p1>=0&&p2>=0) {
            
            nums1[p--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];

        }
        while(p2>=0){
            nums1[p--] = nums2[p2--];
        }


    } 


    // 给出一个区间的集合，请合并所有重叠的区间。

    // 示例 1:
    
    // 输入: [[1,3],[2,6],[8,10],[15,18]]
    // 输出: [[1,6],[8,10],[15,18]]
    // 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    // 示例 2:
    
    // 输入: [[1,4],[4,5]]
    // 输出: [[1,5]]
    // 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
    // 通过次数62,647提交次数154,110
    //https://leetcode-cn.com/problems/merge-intervals/description/
    public static int[][] merge(int[][] intervals) {
        if(intervals==null)
            return null;

        //进行排序
        for (int i = 0; i < intervals.length; i++) {
            int [] temp = intervals[i];
            int index = i;
            for (int j = i+1; j < intervals.length; j++) {
                if(temp[0]>intervals[j][0]){
                    temp = intervals[j];
                    index = j;
                }
            }

            intervals[index] = intervals[i];
            intervals[i] = temp;
        }

        List<int[]>resLsit= new ArrayList<>();
        resLsit.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int []temp =resLsit.get(resLsit.size()-1);
            if(temp[1]<intervals[i][0])
            resLsit.add(intervals[i]);
            else if(temp[1]>=intervals[i][0] && temp[1]<intervals[i][1]){
                temp[1] = intervals[i][1];
                resLsit.set(resLsit.size()-1, temp);
            }
        }

        int [][]res = new int [resLsit.size()][2];
        for (int i = 0; i < resLsit.size(); i++) {
            res[i] = resLsit.get(i);
        }


        return res;
    }



    public static void main(String[] args) {
       int [][] intervals = new int [][] {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
            
            
    }
}