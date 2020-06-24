package niuke;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FirstNotRepeatingChar {
    //比较差的方法
    public int firstNotRepeatingChar(String str) {
        if (str==null || str.length()==0) {
            return 0;
        }

        Map<Character,Integer> charMap = new LinkedHashMap <>();
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            
            if (charSet.contains(str.charAt(i))){
                charMap.remove(str.charAt(i));
            }else{
                charSet.add(str.charAt(i));
                charMap.put(str.charAt(i), i);
            }
                
        }
        Iterator<Entry<Character, Integer>> entries = charMap.entrySet().iterator();
        Entry<Character, Integer> entry = entries.next();

        return entry.getValue();
    }

    //更好的方法，使用hash
    public int firstNotRepeatingChar2(String str) {

            int[] words = new int[58];
            for(int i = 0;i<str.length();i++){
                words[((int)str.charAt(i))-65] += 1;
            }
            for(int i=0;i<str.length();i++){
                if(words[((int)str.charAt(i))-65]==1)
                    return i;
            }
            return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar f = new FirstNotRepeatingChar();
        String str = "google";
        System.out.println(f.firstNotRepeatingChar(str));
    }
}