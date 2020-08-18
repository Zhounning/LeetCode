package leetCode;

import java.util.HashMap;
import java.util.Map;

public class longestAwesome {
    public int LongestAwesome(String s) {
        int status = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        map.put(status, -1);
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - '0';
            // 前缀和
            status = status ^ (1 << ch);

            // 判断一个数字出现奇数次，其余数字出现偶数的情况
            for (int j = 0; j < 10; j++) {
                // 将对应位置的奇偶性改变
                // next现在和status现在存在一位的差异
                // status为偶数次，next为奇数次；或者status为奇数次，next为偶数次
                // 如果next存在则是一个超赞子串
                // 因为从next到status只有一位发生变化，其他不变，说明为1个奇数次，其他偶数次
                int next = status ^ (1 << j);
                if (map.containsKey(next)) {
                    res = Math.max(res, i - map.get(next));
                }
            }
            // 说明所有都出现了偶数次
            if (map.containsKey(status)) {
                res = Math.max(res, i - map.get(status));
            } else {
                map.put(status, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        longestAwesome l = new longestAwesome();
        String s = "3242415";
        System.out.println(l.LongestAwesome(s));
    }
}