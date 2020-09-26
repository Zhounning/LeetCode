package leetCode.offer;

import java.util.Arrays;
import java.util.Comparator;

public class minNumber {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String string : str) {
            sb.append(string);
        }
        return sb.toString();
    }
}