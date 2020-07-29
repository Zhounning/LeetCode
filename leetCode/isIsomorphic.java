package leetCode;

import java.util.HashMap;

public class isIsomorphic {
    public boolean IsIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //如果包含
                Character c = map.get(s.charAt(i));
                if (!c.equals(t.charAt(i))) {
                    return false;
                }
            } else {
                if (map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }

        }
        return true;
    }

    public static void main(String[] args) {
        isIsomorphic i = new isIsomorphic();
        String s = "ac";
        String t = "ba";
        System.out.println(i.IsIsomorphic(s, t));
    }
}