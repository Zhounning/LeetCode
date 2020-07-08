package leetCode;

import java.util.Stack;

/**
 * 难
 */
public class trap {
    //究极无敌暴力法
    public int Trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length-1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j>=0; j--) {
                max_left = Math.max(max_left,  height[j]);
            }

            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    //动态规划
    public int Trap2(int[] height){
        if(height == null||height.length==0)return 0;
        int ans = 0;
        int size = height.length;
        int[]left_max = new int[size];
        int[]right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < right_max.length; i++) {
            left_max[i] = Math.max(height[i],left_max[i-1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size-2; i>=0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    public int Trap3(int[] height){
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current<height.length) {
            while (!st.isEmpty() && height[current] > height[st.peek()]) {
                int top =st.pop();
                if (st.isEmpty())break;
                int dist = current-st.peek()-1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                ans += dist * bounded_height;
            }
            st.add(current++);
        }
        return ans;
    }

    public int Trap4(int[] height){
        int left = 0,right = height.length-1;
        int ans=0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left]>=left_max){
                    left_max = height[left];
                }
                else{
                    ans += (left_max - height[left]);
                }
                ++left;
            }
            else {
                if(height[right]>=right_max ){
                    right_max = height[right];
                }
                else{
                    ans += (right_max  - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}