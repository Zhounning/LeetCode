package leetCode.offer;

public class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] hash = new int[256];

        int l = 0, ans = 1;
        for (int r = 0; r < s.length(); r++) {
            hash[s.charAt(r)]++;
            while (hash[s.charAt(r)] != 1) {
                hash[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}