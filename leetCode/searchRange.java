package leetCode;

import java.util.Arrays;

public class searchRange {
    public int[] SearchRange(int[] nums, int target) {
        if (nums==null||nums.length==0) {
            return new int[]{-1,-1};
        }
        int left =0,right = nums.length-1,mid = 0;

        int first = -1;
        int last = -1;
        //寻找第一个出现
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]==target){
                if ((mid>0 && nums[mid-1]!=target) || mid==0) {
                    first=mid;
                    break;
                }else{
                    right = mid-1;
                }
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        //寻找最后一个出现
        left = 0;right = nums.length-1;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]==target){
                if ((mid<nums.length-1 && nums[mid+1]!=target) || mid==nums.length-1) {
                    last=mid;
                    break;
                }else{
                    left = mid+1;
                }

            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return new int[]{first,last};
    }

    public static void main(String[] args) {
        searchRange s =new searchRange();
        int []nums = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(Arrays.toString(s.SearchRange(nums, target)));
    }
}