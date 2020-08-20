package leetCode;

public class checkInclusion {
    public boolean CheckInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int[] hash = new int[26];
        for (int i = 0; i < s1Arr.length; i++) {
            hash[s1Arr[i] - 'a']++;
        }
        int l = 0, count = 0;
        for (int r = 0; r < s2Arr.length; ++r) {
            hash[s2Arr[r] - 'a']--;
            if (hash[s2Arr[r] - 'a'] >= 0) {
                count++;
            }

            if (r > s1Arr.length - 1) {
                // 说明长度够判断是否需要移动
                hash[s2Arr[l] - 'a']++;

                if (hash[s2Arr[l] - 'a'] >= 1) {
                    count--;
                }
                l++;
            }

            if (count == s1Arr.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        checkInclusion c = new checkInclusion();
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(c.CheckInclusion(s1, s2));
    }
}