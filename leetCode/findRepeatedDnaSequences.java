package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findRepeatedDnaSequences {
    public List<String> FindRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findRepeatedDnaSequences f = new findRepeatedDnaSequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(f.FindRepeatedDnaSequences(s));
    }
}