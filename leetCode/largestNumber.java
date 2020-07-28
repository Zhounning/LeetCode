package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {
    public String LargestNumber(int[] nums) {
        String[] StrNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            StrNums[i] = String.valueOf(nums[i]);
        }
        // 进行比较
        Arrays.sort(StrNums, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }

        });
        StringBuilder sb = new StringBuilder();
        for (String string : StrNums) {
            sb.append(string);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}