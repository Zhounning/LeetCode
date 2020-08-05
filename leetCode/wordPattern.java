package leetCode;

import java.util.HashMap;

public class wordPattern {
    public boolean WordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(words[i])) {
                    return false;
                }

            } else if (map.containsValue(words[i])) {
                return false;
            } else {
                map.put(ch, words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        wordPattern w = new wordPattern();
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(w.WordPattern(pattern, str));
    }
}