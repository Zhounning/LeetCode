package leetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 注意t可以重复
 */
public class minWindow {

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    // 记录滑动窗口时，各个字母出现的次数
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    // 标准答案，速度比较慢
    public String MinWindow(String s, String t) {
        int tLen = t.length();
        // 记录t中单词的次数
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = s.length() + 1, ansL = -1, ansR = -1;
        int sLen = s.length();

        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    /***
     * 判断是否成功全部包含
     * 
     * @return
     */
    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    // 思想跟上面相同
    public String MinWindow2(String s, String t) {
        // 遇到字符的哈希时，常常可以使用的技巧
        int[] mp = new int[256];
        for (char c : t.toCharArray())
            mp[c] += 1;
        int start = 0, end = 0;
        int n = s.length(), m = t.length();
        int cnt = 0;
        int minlen = -1;
        String ans = "";
        while (end < n) {
            char c = s.charAt(end);
            mp[c] -= 1;
            if (mp[c] >= 0)
                cnt += 1;
            while (cnt == m) {
                if (minlen == -1 || minlen > end - start + 1) {
                    ans = s.substring(start, end + 1);
                    minlen = end - start + 1;
                }
                c = s.charAt(start);
                mp[c] += 1;
                // 说明不满足查找到t串的要求了
                if (mp[c] >= 1)
                    cnt -= 1;
                start += 1;
            }
            end += 1;
        }
        return ans;
    }

    // 使用上面的模板进行解题，受篇幅限制下面的代码就不添加注释了
    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] hash = new int[256];
        for (int i = 0; i < tArr.length; ++i) {
            hash[tArr[i]]++;
        }
        int l = 0, count = tArr.length, max = s.length() + 1;
        String result = "";
        for (int r = 0; r < sArr.length; ++r) {
            hash[sArr[r]]--;

            if (hash[sArr[r]] >= 0) {
                count--;
            }

            while (l < r && hash[sArr[l]] < 0) {
                hash[sArr[l]]++;
                l++;
            }

            if (count == 0 && max > r - l + 1) {
                max = r - l + 1;
                result = s.substring(l, r + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        minWindow m = new minWindow();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(m.minWindow2(s, t));
    }
}