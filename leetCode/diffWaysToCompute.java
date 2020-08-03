package leetCode;

import java.util.ArrayList;
import java.util.List;

public class diffWaysToCompute {

    public List<Integer> DiffWaysToCompute(String input) {

        return dfs(input);
    }

    private List<Integer> dfs(String input) {
        List<Integer> ans = new ArrayList<>();
        if (input == null || input.length() == 0) {
            return ans;
        }
        boolean isNum = true;
        for (int i = 0; i < input.length(); i++) {
            // 说明有符号
            List<Integer> nums1;
            List<Integer> nums2;
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                nums1 = dfs(input.substring(0, i));
                nums2 = dfs(input.substring(i + 1, input.length()));
                for (Integer num1 : nums1) {
                    for (Integer num2 : nums2) {
                        if (input.charAt(i) == '+') {
                            ans.add(num1 + num2);

                        } else if (input.charAt(i) == '-') {
                            ans.add(num1 - num2);
                        } else {
                            ans.add(num1 * num2);
                        }
                    }
                }
                isNum = false;
            }
        }

        if (!isNum) {
            // 说明含有运算符
            return ans;
        }
        ans.add(Integer.valueOf(input));
        return ans;
    }

    public static void main(String[] args) {
        diffWaysToCompute d = new diffWaysToCompute();
        String input = "2*3-4*5";
        System.out.println(d.DiffWaysToCompute(input));
    }
}