package leetCode.offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class maxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        // 单调栈
        LinkedList<Integer> stack = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (stack.isEmpty() || stack.peekLast() >= nums[i]) {
                stack.addLast(nums[i]);
            } else {
                while (!stack.isEmpty()&&stack.peekLast() < nums[i]) {
                    stack.pollLast();
                }
                stack.addLast(nums[i]);
            }
        }
        ans.add(stack.peekFirst());
        int l = 0;
        for (int r = k; r < nums.length; r++) {
            if (stack.isEmpty() || stack.peekLast() >= nums[r]) {
                stack.addLast(nums[r]);
            } else {
                while (!stack.isEmpty()&&stack.peekLast() < nums[r]) {
                    stack.pollLast();
                }
                stack.addLast(nums[r]);
            }

            if (stack.peekFirst() == nums[l]) {
                stack.pollFirst();
            }
            l++;
            ans.add(stack.peekFirst());
        }

        int[] a = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
}