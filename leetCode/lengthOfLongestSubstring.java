package leetCode;

import java.util.Set;
import java.util.HashSet;

/**
 * 2020-047-02 所做
 */
public class lengthOfLongestSubstring {

    public int LengthOfLongestSubstring(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        // 保证p1到p2之间没有重复值
        int p1 = 0;
        int p2 = 1;
        int maxLength = 1;
        Set<Character> helperSet = new HashSet<>();
        char[] chars = s.toCharArray();
        helperSet.add(chars[p1]);

        while (p2 < s.length()) {

            if (!helperSet.contains(chars[p2])) {
                helperSet.add(chars[p2]);
                maxLength = Math.max(maxLength, p2 - p1 + 1);
                p2++;

            } else {
                while (chars[p1] != chars[p2]) {
                    helperSet.remove(chars[p1]);
                    p1++;
                }
                p1++;
                p2++;
            }
        }
        return maxLength;
    }

    public int LengthOfLongestSubstring2(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        char[] sArr = s.toCharArray();
        int[] hash = new int[256];
        int l = 0, result = 1;
        for (int r = 0; r < sArr.length; ++r) {
            hash[sArr[r]]++;
            // 说明sArr[r]出现了两次
            while (hash[sArr[r]] != 1) {
                hash[sArr[l]]--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring l = new lengthOfLongestSubstring();
        String s = "pwwkew";
        System.out.println(l.LengthOfLongestSubstring2(s));
    }
}