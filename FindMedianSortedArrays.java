/**
 * FindMedianSortedArrays
 */
public class FindMedianSortedArrays {
//     给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

// 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

// 你可以假设 nums1 和 nums2 不会同时为空。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length+nums2.length)%2!=0)
        return getTopK(nums1, nums2,(nums1.length+nums2.length)/2+1);
    
        return (getTopK(nums1, nums2,(nums1.length+nums2.length)/2)+
            getTopK(nums1,nums2,(nums1.length+nums2.length)/2+1))/2;
    }

    /***
     * 寻找第k小的数，采取的方法是分治算法
     * @param nums1
     * @param nums2
     * @param k 从1开始数的第k个数
     * @return
     */
    public double getTopK(int[] nums1,int [] nums2,int k){
        if(nums1==null||nums1.length==0)
            return nums2[k-1];

        if(nums2==null||nums2.length==0)
            return nums1[k-1];

        if(k==1)
            return nums1[0]<nums2[0]? nums1[0]:nums2[0];

        //两个数组的长度都大于k/2
        if (nums1.length>=k/2&&nums2.length>=k/2) {
                
            int [] nums = null;     //发生变化的数组
            int [] nextnums = null; //不会发生变化的数组
            int length = 0;
            //int [] nums3 = null;
            //nums1前面k/2数小于nums2前面k/2个数
            //说明nums1前面k/2个数一定不会是topk
            if(nums1[k/2-1]<=nums2[k/2-1]){
                length = nums1.length;
                nums = nums1;
                nextnums = nums2;
            }
            else{
               
                length = nums2.length;
                nums = nums2;
                nextnums = nums1;
            }
            int [] nums3 = new int[length-k/2];
            for(int i=(k/2),j=0;i<length;i++)
            {
                nums3[j++]=nums[i];
            }
            return getTopK(nums3,nextnums,k-k/2);

        }
        else{
            //说明其中有一个数组长度小于k/2
            //因为如果两个数组长度都小于k/2，那两个数组相加都找不到topk
            
            int [] minnums = nums1.length<nums2.length?nums1:nums2; //长度较小的数组
            int [] maxnums = nums1.length<nums2.length?nums2:nums1; //长度较大的数组
            
            //说明minnums里面的元素全部排除
            if(minnums[minnums.length-1]<=maxnums[minnums.length-1]){
                return maxnums[k-minnums.length-1];
            }else{
                //只能排除maxnums中的前几个了
                int [] nums3 = new int[maxnums.length-minnums.length];
                for(int i=minnums.length,j=0;i<maxnums.length;i++)
                {
                    nums3[j++]=maxnums[i];
                }
                return getTopK(minnums,nums3,k-minnums.length);
            }

        }
         
    }
    public static void main(String[] args) {
        FindMedianSortedArrays f =new FindMedianSortedArrays();
        int []nums1 ={2};
        int [] nums2 ={1,3,4,5,6};
        System.out.println(f.findMedianSortedArrays(nums1, nums2));
    }

}