package leetCode.offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class firstUniqChar {
    public char FirstUniqChar(String s) {
        if (s.length() == 0)
            return ' ';

        char ans = ' ';
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;

    }
}