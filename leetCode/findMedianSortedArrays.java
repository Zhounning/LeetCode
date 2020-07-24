package leetCode;
/**
 * FindMedianSortedArrays
 */
public class findMedianSortedArrays {

    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length+nums2.length)%2!=0)
        return getTopK(nums1, nums2,(nums1.length+nums2.length)/2+1);
    
        return (getTopK(nums1, nums2,(nums1.length+nums2.length)/2)+
            getTopK(nums1,nums2,(nums1.length+nums2.length)/2+1))/2;
    }
    //k从1开始
    public double getTopK(int[] nums1,int [] nums2,int k){
    
        if(nums1==null||nums1.length==0)return nums2[k-1];

        if(nums2==null||nums2.length==0)return nums1[k-1];
        
        if(k==1)return nums1[0]<nums2[0]? nums1[0]:nums2[0];

         //两个数组的长度都大于k/2
        if (nums1.length>=k/2 && nums2.length>=k/2) {
            int [] nums = null;     //发生变化的数组
            int [] nextnums = null; //不会发生变化的数组
            int length = 0;
             //nums1前面k/2数小于nums2前面k/2个数
            //说明nums1前面k/2个数一定不会是topk
            if(nums1[k/2-1]<=nums2[k/2-1]){
                length = nums1.length;
                nums = nums1;
                nextnums = nums2;
            }else{
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

        }else{
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

    public double FindMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n +1) / 2;
        int right = (m + n+2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    
    // k 是从1开始，方便本题进行计算
    //eg:[1,3],[2] 使用1开始比较方便，而使用0就会导致下标难以找到
    // i为nums1的起始位置，j为nums2的起始位置
    double findKth(int[] nums1,int i,int[] nums2,int j,int k){
        //说明nums1被遍历完了
        if(i>=nums1.length)return nums2[j+k-1];
        //说明nums2被遍历完了
        if(j>=nums2.length)return nums1[i+k-1];
        if(k==1) return Math.min(nums1[i],nums2[j]);
        
        //当 i+k/2 <nums1.length时，第k可能出现在nums1当中，比较好比较
        //当 j+k/2 >nums1.length时,那另一组的前k/2个数一定不是 第k个数
        //eg：nums1数组长度为2，nums2数组长度为12，k为7，k/2为3，2+3<7 所以nums2前3个一定不是
        int midNum1 = i+k/2-1 < nums1.length ?nums1[i+k/2-1] : Integer.MAX_VALUE;
        int midNum2 = j+k/2-1 < nums2.length ?nums2[j+k/2-1] : Integer.MAX_VALUE;

        if(midNum1<midNum2){
            return findKth(nums1, i+k/2, nums2, j, k-k/2);
        }else{
            return findKth(nums1, i, nums2, j+k/2, k-k/2);
        }
    }




    public static void main(String[] args) {
        findMedianSortedArrays f =new findMedianSortedArrays();
        int []nums1 ={1,3,5,7,9};
        int [] nums2 ={2,4,6,8,10};
        System.out.println(f.FindMedianSortedArrays(nums1, nums2));
    }

}