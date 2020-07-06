package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int word_length = words[0].length();
        int word_num = words.length;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //滑动窗口，分情况
        //将所有移动分成 word_length 类情况
        for (int i = 0; i < word_length; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            //每次移动一个单词长度
            while (right + word_length <= s.length()) {
                String w = s.substring(right, right + word_length);
                right += word_length;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;
                  //一直移除单词，直到次数符合了
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + word_length);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += word_length;
                    }
                    if (count == word_num) res.add(left);
                }
            }
        }
        return res;
    }
   
}