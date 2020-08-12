package leetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class avoidFlood {
    public int[] AvoidFlood(int[] rains) {
        int n = rains.length;
        Set<Integer> set = new HashSet<>();
        int res[] = new int[n];
        Arrays.fill(res, 1);
        int count = 0;// 抽干的机会
        int index = 0;
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                // 说明这一天下雨
                // 下雨什么都干不了
                res[i] = -1;

                if (set.contains(rains[i])) {
                    // 说明湖泊有水
                    if (count > 0) {
                        // 说明可以抽干
                        res[index + 1] = rains[i];
                        index++;    
                    } else {
                        return new int[0];
                    }
                } else {
                    set.add(rains[i]);
                }
                if (count == 0) {
                    index = i;
                }
            } else {
                // 说明这一天不下雨，那么需要抽干一个湖
                // 机会加一
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        avoidFlood a = new avoidFlood();
        int[] rains = { 1, 0, 2, 0, 2, 1 };
        System.out.println(Arrays.toString(a.AvoidFlood(rains)));
    }
}