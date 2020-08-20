package leetCode;

public class characterReplacement {
    public int CharacterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] sArr = s.toCharArray();

        int[] hash = new int[26];

        int l = 0, maxCount = 0, result = 0;
        for (int r = 0; r < sArr.length; ++r) {
            hash[sArr[r] - 'A']++;

            maxCount = Math.max(maxCount, hash[sArr[r] - 'A']);

            while (r - l + 1 - maxCount > k) {
                hash[sArr[l] - 'A']--;
                l++;
            }

            result = Math.max(r - l + 1, result);
        }

        return result;
    }
}