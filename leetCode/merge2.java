package leetCode;

import java.util.Arrays;

/**
 * 题目：合并两个有序数组
 */
public class merge2 {
    //类似于合并两个有序链表.但是我们采取倒着插入
    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    public static void main(String[] args) {
        merge2 m2 = new merge2();
        int[] nums1={1,2,3,0,0,0} ;
        int m=3;
        int[] nums2={2,5,6}; 
        int n=3;
        m2.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}