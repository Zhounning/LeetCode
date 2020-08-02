package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class majorityElement2 {

    // 哈希表法
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > (n / 3)) {
                res.add(num);
                map.put(num, 0 - n);
            }
        }
        return res;
    }

    // 摩尔投票法
    public List<Integer> majorityElement3(int[] nums) {
        // 创建返回值
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        // 初始化两个候选人candidate，和他们的计票
        int cand1 = nums[0], count1 = 0;
        int cand2 = nums[0], count2 = 0;

        // 摩尔投票法，分为两个阶段：配对阶段和计数阶段
        // 配对阶段
        for (int num : nums) {
            // 投票
            if (cand1 == num) {
                count1++;
                continue;
            }
            if (cand2 == num) {
                count2++;
                continue;
            }

            // 第1个候选人配对
            if (count1 == 0) {
                cand1 = num;
                count1++;
                continue;
            }
            // 第2个候选人配对
            if (count2 == 0) {
                cand2 = num;
                count2++;
                continue;
            }

            count1--;
            count2--;
        }

        // 计数阶段
        // 找到了两个候选人之后，需要确定票数是否满足大于 N/3
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (cand1 == num)
                count1++;
            else if (cand2 == num)
                count2++;
        }

        if (count1 > nums.length / 3)
            res.add(cand1);
        if (count2 > nums.length / 3)
            res.add(cand2);

        return res;
    }

    public static void main(String[] args) {
        majorityElement2 m = new majorityElement2();
        int[] nums = { 1, 1, 1, 3, 3, 2, 2, 2 };
        System.out.println(m.majorityElement(nums));
    }
}